package objektwerks.ui

import scalafx.Includes.*
import scalafx.collections.ObservableBuffer
import scalafx.geometry.Insets
import scalafx.scene.control.{Button, Label, SelectionMode, TableColumn, TableView}
import scalafx.scene.layout.{HBox, VBox}

import objektwerks.{Store, Todo}

final class Todos(context: Context, store: Store) extends VBox:
  padding = Insets(6)

  val labelTodos = new Label:
    padding = Insets(3)
    text = context.labelTodos

  val tableViewTodos = new TableView[Todo]():
    columns ++= List(
      new TableColumn[Todo, Int]:
        prefWidth = 20
        text = context.columnId
        cellValueFactory = _.value.idProperty
      ,
      new TableColumn[Todo, String]:
        prefWidth = 90
        text = context.columnCreated
        cellValueFactory = _.value.createdProperty
      ,
      new TableColumn[Todo, String]:
        prefWidth = 90
        text = context.columnCompleted
        cellValueFactory = _.value.completedProperty
      ,
      new TableColumn[Todo, String]:
        prefWidth = 200
        text = context.columnTodo
        cellValueFactory = _.value.todoProperty
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
    padding = Insets(6)
    children = List(buttonAdd, buttonEdit)

  children = List(labelTodos, tableViewTodos, buttonBar)

  private def add(): Unit = ???

  private def edit(): Unit = ???