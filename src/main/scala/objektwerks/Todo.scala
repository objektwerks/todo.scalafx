package objektwerks

import java.time.Instant

import upickle.default.ReadWriter as JsonSupport

object Todo:
  given Ordering[Todo] = Ordering.by[Todo, String](t => t.created).reverse

  def default(): Todo = Todo(id = 1, todo = "Drink beer!")
  def datetime(): String = Instant.now.toString

@upickle.implicits.serializeDefaults(true)
final case class Todo(id: Int,
                      created: String = datetime(),
                      completed: String = "",
                      todo: String) derives CanEqual, JsonSupport:
  def file: String = s"$id.json"