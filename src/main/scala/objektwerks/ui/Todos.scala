package objektwerks.ui

import scalafx.collections.ObservableBuffer
import scalafx.geometry.Insets
import scalafx.scene.control.{Button, Label, SelectionMode, SelectionModel, TableColumn, TableView}
import scalafx.scene.layout.{HBox, VBox}

import objektwerks.{Store, Todo}

final class Todos(context: Context, store: Store) extends VBox:
  println(context)
  println(store)

  val labelTodos = new Label:
    text = context.labelTodos

  val tableView = new TableView[Todo]():
    columns ++= List(
      new TableColumn[Todo, Int]:
        text = context.columnId
        cellValueFactory = _.value.nameProperty
    )
    items = ObservableBuffer.from( store.listTodos() )
    columnResizePolicy = TableView.ConstrainedResizePolicy
    selectionModel().selectionModeProperty.value = SelectionMode.Single

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

  val buttonBar = new HBox:
    spacing = 6
    padding = Insets(3)
    children = List(buttonAdd, buttonEdit)

  children = List(labelTodos, listViewTodos, buttonBar)

  private def add(): Unit = ???

  private def edit(): Unit = ???