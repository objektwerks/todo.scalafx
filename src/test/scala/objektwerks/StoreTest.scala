package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class StoreTest extends AnyFunSuite with Matchers:
  test("store"):
    val store = Store()
    val todo = Todo.default()    
    store.writeTodo(todo)
    store.readTodo(todo.file) shouldBe todo
    store.listTodos().length should be >= 1
    store.nextId() should be > 1