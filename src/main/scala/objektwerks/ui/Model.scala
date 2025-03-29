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

  def add(todo: Todo): Unit = ???