package objektwerks.ui

import scalafx.collections.ObservableBuffer
import scalafx.scene.control.{Label, ListView}
import scalafx.scene.layout.VBox

import objektwerks.{Store, Todo}

final class Todos(context: Context, store: Store) extends VBox:
  println(context)
  println(store)

  val labelTodos = new Label:
    text = context.labelTodos

  val listViewTodos = new ListView[Todo]:
    items = ObservableBuffer.from( store.listTodos() )