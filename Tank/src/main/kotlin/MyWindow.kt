import javafx.application.Application
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyCode.ENTER
import javafx.scene.input.KeyCode.L
import javafx.scene.input.KeyEvent
import javafx.scene.paint.Color
import org.itheima.kotlin.game.core.Composer
import org.itheima.kotlin.game.core.Painter
import org.itheima.kotlin.game.core.Window

/**
 * 窗体
 * 继承游戏引擎总的窗体
 */
class MyWindow : Window() {
    override fun onCreate() {
    }

    override fun onDisplay() {
        Painter.drawImage("img/tank_u.gif", 200, 0)

        Painter.drawColor(Color.WHITE, 20, 20, 100, 100)
        Painter.drawText("你好", 30, 30)
    }

    override fun onKeyPressed(event: KeyEvent) {
        when (event.code) {
            ENTER -> println("shuru")
            L -> Composer.play("snd/blast.wav")
        }
    }

    override fun onRefresh() {
    }
}

fun main(args: Array<String>) {
    Application.launch(MyWindow::class.java)
}
