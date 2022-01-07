package app.rateme.desktop

import app.rateme.desktop.managers.DesktopAssetsManager
import app.rateme.desktop.render.DesktopRenderer
import app.rateme.main.Game
import app.rateme.main.OS
import app.rateme.main.type.Size
import java.awt.Dimension
import javax.swing.JFrame
import kotlin.concurrent.thread

class DesktopGame(): JFrame() {
    private val renderer = DesktopRenderer(this)
    private val assetsManager = DesktopAssetsManager()

    fun startGame() {
        initWindow()

        // load all assets
        assetsManager.loadAll()

        initGame()
        startRender()
    }

    private fun initGame() {
        // configuring render
        renderer.initRender1(
            Size(size.width, size.height)
        )

        Game(renderer, assetsManager)
            .initGame(
                getCurrentOS()
            )
    }

    private fun initWindow() {
        title = "SMBClone"
        size = Dimension(1200, 700)
        defaultCloseOperation = EXIT_ON_CLOSE
        isUndecorated = true
        isVisible = true
    }

    private fun startRender() {
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