package app.rateme.main

import app.rateme.main.manager.AssetsManager
import app.rateme.main.render.RenderBroadcast
import app.rateme.main.render.Renderer
import app.rateme.main.type.Color
import app.rateme.main.type.Pos
import app.rateme.main.type.Size
import java.lang.Exception

class Game(var renderer: Renderer, var assetsManager: AssetsManager): RenderBroadcast {
    fun initGame(os: OS) {
        D.initD(os)

        renderer.initRender2(this)
    }

    override fun onRender() {
        val screen = renderer.getScreenSize()
        renderer.drawRect(Pos(60, 60), Size(screen.w - 120,  screen.h - 120), Color.RED, 8)
        renderer.drawLine(Pos(0, 0), Pos(screen.w, screen.h), Color.GREEN, 8)
        renderer.drawImage(Pos(100, 100), Size(128, 128), assetsManager.getImage("stone"))
        renderer.drawImage(Pos(228, 100), Size(128, 128), assetsManager.getImage("bonus"))
        renderer.fillRect(Pos(228 + 128, 100), Size(128, 128), Color.BLUE)
        renderer.drawText(Pos(screen.w / 2, screen.h / 2), "Drawing Test", 16, Color.BLACK)

    }
}