package game.model

import game.Config
import game.enum.Direction
import org.itheima.kotlin.game.core.Painter

/**
 * 砖墙
 */
class Tank(override var x: Int, override var y: Int) : View {
    override var width: Int = Config.block
    override var heigt: Int = Config.block

    //方向
    var currentDirection = Direction.UP

    override fun draw() {
        var imagePath = when (currentDirection) {
            Direction.LEFT  -> "img/tank_l.gif"
            Direction.RIGHT -> "img/tank_r.gif"
            Direction.UP    -> "img/tank_u.gif"
            Direction.DOWN  -> "img/tank_d.gif"
        }
        Painter.drawImage(imagePath, x, y)
    }
}