package game.model

import game.Config
import org.itheima.kotlin.game.core.Painter

class Steel(override var x: Int, override var y: Int) : View {
    //    override var x: Int = 300
    //    override var y: Int = 300
    override var width: Int = Config.gameWidth
    override var height: Int = Config.gameHeight

    override fun draw() {
        Painter.drawImage("img/steel.gif", x, y)
    }
}