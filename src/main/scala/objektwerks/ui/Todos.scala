package objektwerks.ui

import scalafx.scene.control.Label
import scalafx.scene.layout.VBox

import objektwerks.Store

final class Todos(context: Context, store: Store) extends VBox:
  println(context)
  println(store)

  val labelTodos = new Label:
    text = context.labelTodos