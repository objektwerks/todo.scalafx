package objektwerks.ui

import scalafx.scene.layout.VBox

import objektwerks.Store

final class Todos(context: Context, store: Store) extends VBox:
  println(context)
  println(store)