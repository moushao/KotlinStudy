package game.model.model


import game.enum.Direction
import game.model.View
import game.model.business.*
import org.itheima.game.Config
import org.itheima.kotlin.game.core.Painter
import java.util.*

/**
 * 敌方坦克
 *
 * 敌方坦克是可以移动的(避开阻挡物)
 * 敌方坦克是可以自动移动的(自己动起来)
 * 敌方坦克是可以阻塞移动
 * 敌方坦克是可以自动射击
 * 敌方坦克是可以被打
 * 敌方坦克是可以销毁
 */
class Enemy(override var x: Int
            , override var y: Int)
    : Movable, AutoMovable, Blockable, AutoShot, Sufferable, Destroyable {

    override var currentDirection: Direction = Direction.DOWN
    override val speed: Int = 8

    override val width: Int = Config.block
    override val height: Int = Config.block

    //坦克不可以走的方向
    private var badDirection: Direction? = null

    private var lastShotTime = 0L
    private var shotFrequency = 800

    private var lastMoveTime = 0L
    private var moveFrequency = 30

    override var blood: Int = 2

    override fun draw() {
        val imagePath = when (currentDirection) {
            Direction.UP -> "img/enemy_1_u.gif"
            Direction.DOWN -> "img/enemy_1_d.gif"
            Direction.LEFT -> "img/enemy_1_l.gif"
            Direction.RIGHT -> "img/enemy_1_r.gif"
        }
        Painter.drawImage(imagePath, x, y)
    }

//    override fun willCollision(block: Blockable): Direction? {
//        return null
//    }

    override fun notifyCollision(direction: Direction?, block: Blockable?) {
        badDirection = direction
    }

    override fun autoMove() {
        //频率检测
        val current = System.currentTimeMillis()
        if (current - lastMoveTime < moveFrequency) return
        lastMoveTime = current

        if (currentDirection == badDirection) {
            // 要往错误方向走，不允许的
            //改变自己方向
            currentDirection = rdmDirection(badDirection)
            return
        }

        //坦克的坐标需要发生变化
        //根据不同的方向，改变对应的坐标
        when (currentDirection) {
            Direction.UP -> y -= speed
            Direction.DOWN -> y += speed
            Direction.LEFT -> x -= speed
            Direction.RIGHT -> x += speed
        }

        //越界判断
        if (x < 0) x = 0
        if (x > Config.gameWidth - width) x = Config.gameWidth - width
        if (y < 0) y = 0
        if (y > Config.gameHeight - height) y = Config.gameHeight - height
    }

    private fun rdmDirection(bad: Direction?): Direction {
        val i = Random().nextInt(4)
        val direction = when (i) {
            0 -> Direction.UP
            1 -> Direction.DOWN
            2 -> Direction.LEFT
            3 -> Direction.RIGHT
            else -> Direction.UP
        }
        //判断 不能要错误的反向
        if (direction == bad) {
            return rdmDirection(bad)
        }
        return direction
    }

    override fun autoShot(): View? {
        val current = System.currentTimeMillis()
        if (current - lastShotTime < shotFrequency) return null
        lastShotTime = current

        return Bullet(this, currentDirection, { bulletWidth, bulletHeight ->
            //计算子弹真实的坐标
            val tankX = x
            val tankY = y
            val tankWidth = width
            val tankHeight = height

            // 如果坦克是向上的，计算子弹的位置
            // bulletX = tankX + (tankWidth - bulletWidth) / 2
            // bulletY = tankY - bulletHeight / 2
            var bulletX = 0
            var bulletY = 0

            when (currentDirection) {
                Direction.UP -> {
                    bulletX = tankX + (tankWidth - bulletWidth) / 2
                    bulletY = tankY - bulletHeight / 2
                }
                Direction.DOWN -> {
                    bulletX = tankX + (tankWidth - bulletWidth) / 2
                    bulletY = tankY + tankHeight - bulletHeight / 2
                }
                Direction.LEFT -> {
                    bulletX = tankX - bulletWidth / 2
                    bulletY = tankY + (tankHeight - bulletHeight) / 2
                }
                Direction.RIGHT -> {
                    bulletX = tankX + tankWidth - bulletWidth / 2
                    bulletY = tankY + (tankHeight - bulletHeight) / 2
                }
            }

            Pair(bulletX, bulletY)
        })
    }

    override fun notifySuffer(attackable: Attackable): Array<View>? {
        if (attackable.owner is Enemy) {
            //挨打,不掉血，不给反应
            return null
        }

        blood -= attackable.attackPower
        return arrayOf(Blast(x, y))
    }

    override fun isDestroyed(): Boolean = blood <= 0

}