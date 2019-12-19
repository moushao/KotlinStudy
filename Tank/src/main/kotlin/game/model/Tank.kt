package game.model

import game.Config
import game.enum.Direction
import org.itheima.kotlin.game.core.Painter

/**
 * 砖墙
 */
class Tank(override var x: Int, override var y: Int) : View {
    override var width: Int = Config.block
    override var height: Int = Config.block

    val speed: Int = 8
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

    fun move(direction: Direction) {
        if (direction != currentDirection) {
            this.currentDirection = direction
            return
        }
        //坦克的坐标需要发生变化,根据不同的方向对应坐标
        when (currentDirection) {
            Direction.UP    -> {
                if (y - speed < 0)
                    y = 0
                else
                    y -= speed
            }
            Direction.LEFT  -> {
                if (x - speed < 0)
                    x = 0
                else
                    x -= speed
            }
            Direction.RIGHT -> {
                if (x >= Config.gameWidth - width)
                    x = Config.gameWidth - width
                else
                    x += speed
            }
            Direction.DOWN  -> {
                if (y >= Config.gameHeight - height)
                    y = Config.gameHeight - height
                else
                    y += speed
            }
        }
    }
}