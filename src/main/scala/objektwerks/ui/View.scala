package objektwerks.ui

import scalafx.scene.Scene
import scalafx.scene.layout.VBox

import objektwerks.Store

final class View(context: Context, store: Store):
  val menu = Menu(context)

  val todos = Todos(context, store)

  val vbox = new VBox:
    prefWidth = context.windowWidth
    prefHeight = context.windowHeight
    children = List(menu, todos)

  val scene = new Scene:
    root = vbox
    stylesheets = List("/style.css")