package objektwerks.ui

import com.typesafe.config.Config

import scalafx.scene.image.{Image, ImageView}

final class Context(config: Config):
  val windowTitle = config.getString("window.title")
  val windowWidth = config.getDouble("window.width")
  val windowHeight = config.getDouble("window.height")

  val aboutAlertHeaderText = config.getString("about.alert.headerText")
  val aboutAlertContentText = config.getString("about.alert.contentText")

  val menuMenu = config.getString("menu.menu")
  val menuAbout = config.getString("menu.about")
  val menuExit = config.getString("menu.exit")

  val columnId = config.getString("column.id")
  val columnCreated = config.getString("column.created")
  val columnCompleted = config.getString("column.completed")
  val columnTodo = config.getString("column.todo")

  val labelTodos = config.getString("label.todos")
  val labelTodo = config.getString("label.todo")
  val labelCompleted = config.getString("label.completed")

  val dialogAddTodoHeaderText = config.getString("dialog.add.todo.HeaderText")
  val dialogAddTodoContentText = config.getString("dialog.add.todo.ContentText")

  val buttonAdd = config.getString("button.add")
  val buttonCompleted = config.getString("button.completed")

  def imageViewAdd = loadImageView("/image/add.png")
  def imageViewCompleted = loadImageView("/image/completed.png")
  def imageAppIcon = Image(Image.getClass.getResourceAsStream("/image/todo.png"))

  private def loadImageView(path: String): ImageView = new ImageView:
    image = Image(Image.getClass.getResourceAsStream(path))
    fitHeight = 22
    fitWidth = 22
    preserveRatio = true
    smooth = true