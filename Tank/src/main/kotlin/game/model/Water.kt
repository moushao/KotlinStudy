package game.model

import game.Config
import org.itheima.kotlin.game.core.Painter

/**
 * 砖墙
 */
class Water(override var x: Int, override var y: Int) : View {
    /* override var x: Int = 200
     override var y: Int = 200*/
    override var width: Int = Config.gameWidth
    override var heigt: Int = Config.gameHeight

    override fun draw() {
        Painter.drawImage("img/water.gif", x, y)
    }
}