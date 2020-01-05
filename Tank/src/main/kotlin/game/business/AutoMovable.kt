package game.model.business

import game.enum.Direction
import game.model.View


/**
 * 自动移动的能力
 */
interface AutoMovable : View {

    //方向
    val currentDirection: Direction
    //速度
    val speed: Int

    fun autoMove()
}