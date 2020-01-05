package game.model.model

import game.model.View
import game.model.business.Attackable
import game.model.business.Blockable
import game.model.business.Destroyable
import game.model.business.Sufferable
import org.itheima.game.Config
import org.itheima.kotlin.game.core.Painter

/**
 * 大本营
 *
 * 具备阻挡的功能
 * 具备接受攻击的功能
 * 具备接销毁的能力
 */
class Camp(override var x: Int, override var y: Int) : Blockable, Sufferable, Destroyable {

    override var width: Int = Config.block * 2
    override var height: Int = Config.block + 32

    override var blood: Int = 12

    override fun draw() {

        //血量低于 6个时画的时 砖墙
        //血量低于 3个时画的时 没有墙
        if (blood <= 3) {
            width = Config.block
            height = Config.block
            x = (Config.gameWidth - Config.block) / 2
            y = Config.gameHeight - Config.block
            Painter.drawImage("img/camp.gif", x, y)

        } else if (blood <= 6) {

            //绘制外围的砖块
            Painter.drawImage("img/wall_small.gif", x, y)
            Painter.drawImage("img/wall_small.gif", x + 32, y)
            Painter.drawImage("img/wall_small.gif", x + 64, y)
            Painter.drawImage("img/wall_small.gif", x + 96, y)

            Painter.drawImage("img/wall_small.gif", x, y + 32)
            Painter.drawImage("img/wall_small.gif", x, y + 64)

            Painter.drawImage("img/wall_small.gif", x + 96, y + 32)
            Painter.drawImage("img/wall_small.gif", x + 96, y + 64)

            Painter.drawImage("img/camp.gif", x + 32, y + 32)

        } else {

            //绘制外围的砖块
            Painter.drawImage("img/steel_small.gif", x, y)
            Painter.drawImage("img/steel_small.gif", x + 32, y)
            Painter.drawImage("img/steel_small.gif", x + 64, y)
            Painter.drawImage("img/steel_small.gif", x + 96, y)

            Painter.drawImage("img/steel_small.gif", x, y + 32)
            Painter.drawImage("img/steel_small.gif", x, y + 64)

            Painter.drawImage("img/steel_small.gif", x + 96, y + 32)
            Painter.drawImage("img/steel_small.gif", x + 96, y + 64)

            Painter.drawImage("img/camp.gif", x + 32, y + 32)

        }
    }

    override fun notifySuffer(attackable: Attackable): Array<View>? {
        // 被打时
        blood -= attackable.attackPower

        if (blood == 3 || blood == 6) {
            val x = x - 32
            val y = y - 32
            return arrayOf(Blast(x, y)
                    , Blast(x + 32, y)
                    , Blast(x + Config.block, y)
                    , Blast(x + Config.block + 32, y)
                    , Blast(x + Config.block * 2, y)
                    , Blast(x, y + 32)
                    , Blast(x, y + Config.block)
                    , Blast(x, y + Config.block + 32)
                    , Blast(x + Config.block * 2, y + 32)
                    , Blast(x + Config.block * 2, y + Config.block)
                    , Blast(x + Config.block * 2, y + Config.block + 32))
        }

        return null
    }

    override fun isDestroyed(): Boolean = blood <= 0

    override fun showDestroy(): Array<View>? {
        return arrayOf(Blast(x - 32, y - 32)
                , Blast(x, y - 32)
                , Blast(x + 32, y - 32)

                , Blast(x - 32, y)
                , Blast(x, y)
                , Blast(x + 32, y)

                , Blast(x - 32, y + 32)
                , Blast(x, y + 32)
                , Blast(x + 32, y + 32))
    }
}