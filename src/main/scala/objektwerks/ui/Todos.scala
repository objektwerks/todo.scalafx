package objektwerks.ui

import scalafx.collections.ObservableBuffer
import scalafx.scene.control.{Button, Label, ListView}
import scalafx.scene.layout.VBox

import objektwerks.{Store, Todo}

final class Todos(context: Context, store: Store) extends VBox:
  println(context)
  println(store)

  val labelTodos = new Label:
    text = context.labelTodos

  val listViewTodos = new ListView[Todo]:
    items = ObservableBuffer.from( store.listTodos() )

  val buttonAdd = new Button:
    graphic = context.imageViewAdd
    text = context.buttonAdd
    disable = false
    onAction = { _ => add() }

  val buttonEdit = new Button:
    graphic = context.imageViewEdit
    text = context.buttonEdit
    disable = false
    onAction = { _ => edit() }

  private def add(): Unit = ???

  private def edit(): Unit = ???