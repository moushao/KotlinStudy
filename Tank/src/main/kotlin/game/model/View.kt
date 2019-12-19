package game.model

import game.Config

/**
 * 显示视图,定义显示规范
 */
interface View {
    //宽高
    var x: Int
    var y: Int

    //位置
    var width: Int
    var height: Int

    //显示
    fun draw()
}