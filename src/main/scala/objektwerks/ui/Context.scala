package objektwerks.ui

import com.typesafe.config.Config

import scalafx.scene.image.Image

final class Context(config: Config):
  val windowTitle = config.getString("window.title")
  val windowWidth = config.getDouble("window.width")
  val windowHeight = config.getDouble("window.height")

  val aboutAlertHeaderText = config.getString("about.alert.headerText")
  val aboutAlertContentText = config.getString("about.alert.contentText")

  val menuMenu = config.getString("menu.menu")
  val menuAbout = config.getString("menu.about")
  val menuExit = config.getString("menu.exit")

  val labelTodos = config.getString("label.todos")

  val buttonAdd = config.getString("button.add")
  val buttonEdit = config.getString("button.edit")

  def imageAppIcon = Image(Image.getClass.getResourceAsStream("/image/todo.png"))