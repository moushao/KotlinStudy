package game.model.model

import game.enum.Direction
import game.model.View
import game.model.business.Attackable
import game.model.business.AutoMovable
import game.model.business.Destroyable
import game.model.business.Sufferable
import game.model.ext.checkCollision
import org.itheima.game.Config
import org.itheima.kotlin.game.core.Painter

/**
 * 子弹
 *
 * create()函数返回两个值，是x，y
 */
class Bullet(override val owner: View, override val currentDirection: Direction
             , create: (width: Int, height: Int) -> Pair<Int, Int>)
    : AutoMovable, Destroyable, Attackable, Sufferable {

    override val blood: Int = 1

    //给子弹一个方向，方向由坦克来决定
    override val width: Int
    override val height: Int

    override var x: Int = 0
    override var y: Int = 0

    override val speed: Int = 8

    private var isDestroyed = false

    override val attackPower: Int = 1

    private val imagePath: String = when (currentDirection) {
        Direction.UP -> "img/shot_top.gif"
        Direction.DOWN -> "img/shot_bottom.gif"
        Direction.LEFT -> "img/shot_left.gif"
        Direction.RIGHT -> "img/shot_right.gif"
    }

    init {
        // 先计算宽度和高度
        val size = Painter.size(imagePath)
        width = size[0]
        height = size[1]

        val pair = create.invoke(width, height)
        x = pair.first
        y = pair.second
    }

    override fun draw() {
        Painter.drawImage(imagePath, x, y)
    }

    override fun autoMove() {

        //根据自己的方向，来改变自己的x和y
        when (currentDirection) {
            Direction.UP -> y -= speed
            Direction.DOWN -> y += speed
            Direction.LEFT -> x -= speed
            Direction.RIGHT -> x += speed
        }
    }

    override fun isDestroyed(): Boolean {
        if (isDestroyed) return true

        //子弹在脱离了屏幕后，需要被销毁
        if (x < -width) return true
        if (x > Config.gameWidth) return true
        if (y < -height) return true
        if (y > Config.gameHeight) return true

        return false
    }

    override fun isCollision(sufferable: Sufferable): Boolean {
        return checkCollision(sufferable)
    }

    override fun notifyAttack(sufferable: Sufferable) {
//        println("子弹接收到碰撞了..")
        //子弹打到墙上后，子弹要销毁掉
        isDestroyed = true
    }

    override fun notifySuffer(attackable: Attackable): Array<View>? {
        return arrayOf(Blast(x, y))
    }

}