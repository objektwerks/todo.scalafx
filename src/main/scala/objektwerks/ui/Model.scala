package objektwerks.ui

import com.typesafe.scalalogging.LazyLogging

import scalafx.beans.property.ObjectProperty
import scalafx.collections.ObservableBuffer

import objektwerks.{Todo, Store}

final class Model(val store: Store) extends LazyLogging:
  val todos = store.listTodos()
  val observableTodos = ObservableBuffer.from( store.listTodos() ).sorted
  val selectedTodo = ObjectProperty( Todo(id = 0, todo = "") )

  logger.info("Initialized model.")

  def add(todo: String): Unit =
    val newTodo = Todo(id = store.nextId(), todo = todo)
    store.writeTodo(newTodo)
    observableTodos.insert(0, newTodo)
    selectedTodo.value = newTodo
    logger.info(s"Added todo: $newTodo")

  def completed(): Unit =
    val completedTodo = selectedTodo.value.copy(completed = Todo.datetime())
    store.writeTodo(completedTodo)
    val index = observableTodos.indexOf(selectedTodo.value)
    if index > -1 then
      observableTodos.update(index, completedTodo)
      selectedTodo.value = completedTodo
      logger.info(s"Completed todo: $completedTodo")