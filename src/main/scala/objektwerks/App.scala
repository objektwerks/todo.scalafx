package objektwerks

import com.typesafe.scalalogging.LazyLogging

import mainargs.{main, arg, ParserForMethods}

object App extends LazyLogging:
  val store = Store()

  @main
  def list( @arg filter: String = Filter.all ): Unit =
    log(s"list by filter: $filter")
    val todos = store.listTodos()
    filter match
      case Filter.all => list(todos)
      case Filter.completed => list( todos.filter(todo => todo.completed.nonEmpty) )
      case Filter.incomplete => list( todos.filter(todo => todo.completed.isEmpty) )
      case _ => log("list --filter all | completed | incomplete")

  @main
  def add( @arg todo: String* ): Unit =
    val newTodo = Todo(id = store.nextId(), todo = todo.tail.mkString(" "))
    store.writeTodo(newTodo)
    log(s"add --todo: $newTodo")

  @main
  def complete( @arg id: Int ): Unit =
    val todo = store.readTodo(s"$id.json")
    val completedTodo = todo.copy(completed = Todo.datetime())
    store.writeTodo(completedTodo)
    log(s"completed --id: $completedTodo")

  @main
  def help(): Unit =
    menu()

  def main(args: Array[String]): Unit =
    if args.isEmpty then menu()
    else ParserForMethods(this).runOrExit(args)

  private def menu(): Unit =
    log("menu:")
    log("1. list --filter all | completed | incomplete")
    log("2. add --todo")
    log("3. complete --id")
    log("4. help")

  private def log(message: String): Unit =
    println(message)
    logger.info(message)

  private def list(todos: List[Todo]): Unit =
    todos
      .zip( Stream.from(1) )
      .foreach { case (todo, index) => println(s"$index. $todo") }