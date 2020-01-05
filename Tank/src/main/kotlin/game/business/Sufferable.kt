package game.model.business

import game.model.View


/**
 * 遭受攻击的接口
 */
interface Sufferable : View {

    /**
     * 生命值
     */
    val blood: Int

    fun notifySuffer(attackable: Attackable): Array<View>?
}