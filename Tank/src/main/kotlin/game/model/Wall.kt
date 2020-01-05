package game.model.model

import game.model.View
import game.model.business.Attackable
import game.model.business.Blockable
import game.model.business.Destroyable
import game.model.business.Sufferable
import org.itheima.game.Config
import org.itheima.kotlin.game.core.Composer
import org.itheima.kotlin.game.core.Painter

/**
 * 砖墙
 *
 * 具备阻塞能力
 * 具备挨打能力
 * 具备销毁能力
 */
class Wall(override val x: Int, override val y: Int) : Blockable, Sufferable, Destroyable {

    override var blood: Int = 3

    //位置
//    override val x: Int = 100
//    override val y: Int = 100
    //宽高
    override val width: Int = Config.block
    override val height: Int = Config.block

    //显示行为
    override fun draw() {
        Painter.drawImage("img/wall.gif", x, y)
    }

    override fun isDestroyed(): Boolean = blood <= 0

    //        println("砖墙接收到挨打了..")
    //砖墙要被销毁，砖墙掉血
    override fun notifySuffer(attackable: Attackable): Array<View>? {
        blood -= attackable.attackPower

        //喊疼
        Composer.play("snd/hit.wav")

        return arrayOf(Blast(x, y))
    }


}