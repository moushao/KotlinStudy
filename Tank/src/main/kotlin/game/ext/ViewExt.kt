package game.model.ext

import game.model.View


fun View.checkCollision(view: View): Boolean {
    return checkCollision(x, y, width, height, view.x, view.y, view.width, view.height)
}