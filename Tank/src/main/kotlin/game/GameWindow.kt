package game

import game.enum.Direction
import game.model.*
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import org.itheima.kotlin.game.core.Window
import java.io.File


class GameWindow : Window(title = "坦克大战1.0",
        icon = "img/logo.jpg",
        width = Config.gameWidth,
        height = Config.gameHeight) {

    private lateinit var tank: Tank
    private var views = arrayListOf<View>()

    override fun onCreate() {
        val file = File(javaClass.getResource("/map/1.map").path)
        var lineNum = 0

        val lines = file.readLines()
        lines.forEach {
            var columnNum = 0
            it.toCharArray().forEach {
                when (it) {
                    '砖' -> views.add(Wall(columnNum * Config.block, lineNum * Config.block))
                    '草' -> views.add(Grass(columnNum * Config.block, lineNum * Config.block))
                    '水' -> views.add(Water(columnNum * Config.block, lineNum * Config.block))
                    '铁' -> views.add(Steel(columnNum * Config.block, lineNum * Config.block))
                }
                columnNum++
            }
            lineNum++
        }
        tank = Tank(Config.block * 10, Config.block * 12)
        views.add(tank)
    }

    override fun onDisplay() {
        views.forEach {
            it.draw()
        }
    }

    override fun onKeyPressed(event: KeyEvent) {
        when (event.code) {
            KeyCode.W -> tank.move(Direction.UP)
            KeyCode.A -> tank.move(Direction.LEFT)
            KeyCode.S -> tank.move(Direction.DOWN)
            KeyCode.D -> tank.move(Direction.RIGHT)

        }
    }

    override fun onRefresh() {
    }
}