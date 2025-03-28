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

  val buttonAdd = config.getString("button.add")
  val buttonEdit = config.getString("button.edit")

  def imageViewAdd = loadImageView("/image/add.png")
  def imageViewEdit = loadImageView("/image/edit.png")
  def imageAppIcon = Image(Image.getClass.getResourceAsStream("/image/todo.png"))

  private def loadImageView(path: String): ImageView = new ImageView:
    image = Image(Image.getClass.getResourceAsStream(path))
    fitHeight = 22
    fitWidth = 22
    preserveRatio = true
    smooth = true