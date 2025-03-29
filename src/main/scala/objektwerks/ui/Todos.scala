package objektwerks.ui

import scalafx.Includes.*
import scalafx.geometry.Insets
import scalafx.scene.control.{Button, Label, SelectionMode, TableColumn, TableView, TextInputDialog}
import scalafx.scene.layout.{HBox, VBox}

import objektwerks.Todo

final class Todos(context: Context, model: Model) extends VBox:
  padding = Insets(6)

  val labelTodos = new Label:
    padding = Insets(3)
    style = "-fx-font-weight: bold"
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
    items = model.observableTodos
    columnResizePolicy = TableView.ConstrainedResizePolicy
    selectionModel().selectionModeProperty.value = SelectionMode.Single

  tableViewTodos.selectionModel().selectedItemProperty().addListener { (_, _, selectedTodo) =>
    if selectedTodo != null then
      model.selectedTodo.value = selectedTodo
      buttonCompleted.disable = false
  }

  val buttonAdd = new Button:
    graphic = context.imageViewAdd
    text = context.buttonAdd
    disable = false
    onAction = { _ => add() }

  val buttonCompleted = new Button:
    graphic = context.imageViewCompleted
    text = context.buttonCompleted
    disable = true
    onAction = { _ => completed() }

  val buttonBar = new HBox:
    spacing = 6
    padding = Insets(6)
    children = List(buttonAdd, buttonCompleted)

  children = List(labelTodos, tableViewTodos, buttonBar)

  def add(): Unit =
    val dialogAddTodo = new TextInputDialog():
      initOwner(App.stage)
      title = context.windowTitle
      headerText = context.dialogAddTodoHeaderText
      contentText = context.dialogAddTodoContentText
    dialogAddTodo.showAndWait() match
      case Some(todo) => if todo.nonEmpty then model.add(todo)
      case None =>

  def completed(): Unit =
    model.completed()
    buttonCompleted.disable = true