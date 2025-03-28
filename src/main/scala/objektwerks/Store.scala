package objektwerks

import com.typesafe.scalalogging.LazyLogging

import upickle.default.{read => readJson, write => writeJson}

import Todo.given

final class Store extends LazyLogging:
  private val todosPath = os.home / ".todo" / "data"

  os.makeDir.all(todosPath)
  logger.info("Initialized store.")

  def listTodos(): List[Todo] =
    logger.info(s"List todos.")
    os.list(todosPath)
      .filter { path => path.baseName.nonEmpty }
      .map { path => readTodo(s"${path.baseName}.json") }
      .toList
      .sorted

  def readTodo(file: String): Todo =
    val todoAsJson = os.read(todosPath / file)
    logger.info(s"Read todo: $file")
    readJson[Todo](todoAsJson)

  def writeTodo(todo: Todo): Unit =
    val todoAsJson = writeJson(todo)
    os.write.over(todosPath / todo.file, todoAsJson)
    logger.info(s"Write todo: ${todo.id}")

  def nextId(): Int =
    val list = os.list(todosPath)
      .filter { path => path.baseName.nonEmpty }
      .map { path => path.baseName.toInt }
      .toList
    val id = if list.isEmpty then 1 else list.max + 1
    logger.info(s"Next id: $id")
    id