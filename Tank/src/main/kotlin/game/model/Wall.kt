package game.model

import game.Config
import org.itheima.kotlin.game.core.Painter

/**
 * 砖墙
 */
class Wall(override var x: Int, override var y: Int) : View {
    /*override var x: Int = 100
    override var y: Int = 100*/
    override var width: Int = Config.gameWidth
    override var height: Int = Config.gameHeight

    override fun draw() {
        Painter.drawImage("img/wall.gif", x, y)
    }
}