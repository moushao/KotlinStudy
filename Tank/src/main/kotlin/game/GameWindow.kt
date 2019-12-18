package game

import game.model.*
import javafx.scene.input.KeyEvent
import org.itheima.kotlin.game.core.Window
import java.io.File


class GameWindow : Window(title = "坦克大战1.0",
        icon = "img/logo.jpg",
        width = Config.gameWidth,
        height = Config.gameHeight) {

    var views = arrayListOf<View>()

    override fun onCreate() {
        val file = File(javaClass.getResource("/map/1.map").path)
        var lineNum = 0

        val lines = file.readLines()
        lines.forEach {
            var columnNum = 0
            it.toCharArray().forEach {
                when (it) {
                    '砖' -> views.add(Wall(lineNum * Config.block, columnNum * Config.block))
                    '草' -> views.add(Grass(lineNum * Config.block, columnNum * Config.block))
                    '水' -> views.add(Water(lineNum * Config.block, columnNum * Config.block))
                    '铁' -> views.add(Steel(lineNum * Config.block, columnNum * Config.block))
                }
                columnNum++
            }
            lineNum++
        }
        views.add(Tank(Config.block * 10, Config.block * 12))
    }

    override fun onDisplay() {
        views.forEach {
            it.draw()
        }
    }

    override fun onKeyPressed(event: KeyEvent) {
    }

    override fun onRefresh() {
    }
}