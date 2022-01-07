package app.rateme.desktop

import app.rateme.main.Game
import app.rateme.main.OS
import app.rateme.main.type.Size
import java.awt.*
import javax.swing.JFrame
import kotlin.concurrent.thread

fun main() {
    DesktopGame()
        .startGame()
}

class DesktopGame(): JFrame() {
    private val renderer = DesktopRenderer(this)
    private val assetsManager = DesktopAssetsManager()

    fun startGame() {
        title = "SMBClone"
        size = Dimension(800, 600)
        defaultCloseOperation = EXIT_ON_CLOSE
        isUndecorated = true
        isVisible = true

        assetsManager.loadAll()

        // configuring render
        renderer.initRender1(
            Size(size.width, size.height)
        )

        Game(renderer, assetsManager)
            .initGame(
                getCurrentOS()
            )

        thread {
            while (true) {
                renderer.getRenderBroadcast().onRender()
                Thread.sleep(1000 / 60)
            }
        }
    }

    private fun getCurrentOS(): OS {
        if(System.getProperty("os.name").toLowerCase().contains("mac os")) return OS.MACOS
        if(System.getProperty("os.name").toLowerCase().contains("linux")) return OS.LINUX
        if(System.getProperty("os.name").toLowerCase().contains("windows")) return OS.WINDOWS

        return OS.UNKNOWN
    }
}