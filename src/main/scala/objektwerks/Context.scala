package objektwerks

import com.typesafe.config.Config

import scalafx.scene.image.Image

final class Context(config: Config):
  val windowTitle = config.getString("window.title")
  val windowWidth = config.getDouble("window.width")
  val windowHeight = config.getDouble("window.height")

  val aboutAlertHeaderText = config.getString("about.alert.headerText")
  val aboutAlertContentText = config.getString("about.alert.contentText")

  def imageAppIcon = Image(Image.getClass.getResourceAsStream("/todo.png"))