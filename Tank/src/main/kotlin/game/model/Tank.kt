package game.model.model

import game.enum.Direction
import game.model.View
import game.model.business.Attackable
import game.model.business.Blockable
import game.model.business.Movable
import game.model.business.Sufferable
import org.itheima.game.Config
import org.itheima.kotlin.game.core.Painter

/**
 * 我方坦克
 *
 * 具备移动能力
 * 具备阻挡能力
 */
class Tank(override var x: Int, override var y: Int) : Movable, Blockable, Sufferable {

    override val width: Int = Config.block
    override val height: Int = Config.block

    //方向
    override var currentDirection: Direction = Direction.UP

    //速度
    override val speed: Int = 8

    //坦克不可以走的方向
    private var badDirection: Direction? = null

    //血量
    override var blood: Int = 20

    override fun draw() {
        //根据坦克的方向进行绘制
        //方式一:
//        when (currentDirection) {
//            Direction.UP -> Painter.drawImage("img/tank_u.gif", x, y)
//            Direction.DOWN -> Painter.drawImage("img/tank_d.gif", x, y)
//            Direction.LEFT -> Painter.drawImage("img/tank_l.gif", x, y)
//            Direction.RIGHT -> Painter.drawImage("img/tank_r.gif", x, y)
//        }

        //方式二:
        val imagePath = when (currentDirection) {
            Direction.UP -> "img/tank_u.gif"
            Direction.DOWN -> "img/tank_d.gif"
            Direction.LEFT -> "img/tank_l.gif"
            Direction.RIGHT -> "img/tank_r.gif"
        }
        Painter.drawImage(imagePath, x, y)
    }

    /**
     * 坦克移动
     */
    fun move(direction: Direction) {
        // 判断是否是往要碰撞的方向走
        if (direction == badDirection) {
//            不往下执行，不走了
            return
        }


        //当前的方向，和希望移动的方向不一致时，只做方向改变
        if (this.currentDirection != direction) {
            this.currentDirection = direction
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

//    override fun willCollision(block: Blockable): Direction? {
//        //未来的坐标
//        var x = this.x
//        var y = this.y
//        //将要碰撞时做判断
//        when (currentDirection) {
//            Direction.UP -> y -= speed
//            Direction.DOWN -> y += speed
//            Direction.LEFT -> x -= speed
//            Direction.RIGHT -> x += speed
//        }
//
//        //检测碰撞 下一步是否碰撞
////        val collision = when {
////            block.y + block.height <= y -> //如果 阻挡物 在运动物的上方时 ，不碰撞
////                false
////            y + height <= block.y -> //如果 阻挡物 在运动物的下方时 ，不碰撞
////                false
////            block.x + block.width <= x -> //如果 阻挡物 在运动物的左方时 ，不碰撞
////                false
////            else -> x + width > block.x
////        }
//        val collision = checkCollision(block.x, block.y, block.width, block.height
//                , x, y, width, height)
//
//        return if (collision) currentDirection else null
//    }

    override fun notifyCollision(direction: Direction?, block: Blockable?) {
        //接收到碰撞信息
        this.badDirection = direction
    }

    /**
     * 发射子弹的方法
     */
    fun shot(): Bullet {


//        return Bullet(currentDirection, bulletX, bulletY)

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
        blood -= attackable.attackPower
        return arrayOf(Blast(x, y))
    }
}