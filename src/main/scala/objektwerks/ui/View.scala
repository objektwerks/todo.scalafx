package objektwerks.ui

import scalafx.scene.Scene
import scalafx.scene.layout.VBox

final class View(context: Context, model: Model):
  val menu = Menu(context)

  val todos = Todos(context, model)

  val vbox = new VBox:
    prefWidth = context.windowWidth
    prefHeight = context.windowHeight
    children = List(menu, todos)

  val scene = new Scene:
    root = vbox
    stylesheets = List("/style.css")