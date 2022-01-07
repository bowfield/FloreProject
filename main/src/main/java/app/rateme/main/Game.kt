package app.rateme.main

import app.rateme.main.manager.AssetsManager
import app.rateme.main.render.RenderBroadcast
import app.rateme.main.render.Renderer
import app.rateme.main.type.Color
import app.rateme.main.type.Pos
import app.rateme.main.type.Size
import app.rateme.main.ui.UIButton
import app.rateme.main.ui.UIElement
import java.lang.Exception

class Game(var renderer: Renderer, var assetsManager: AssetsManager): RenderBroadcast {
    private val uiElements: ArrayList<UIElement> = arrayListOf()

    fun initGame(os: OS) {
        D.initD(os)
        renderer.initRender2(this)

        appendUiElement(UIButton(Pos(10, 10), Size(160, 40), "Start"))
        appendUiElement(UIButton(Pos(10, 60), Size(160, 40), "Quit"))
    }

    fun appendUiElement(el: UIElement) {
        uiElements.add(el)
    }

    private fun renderUi() {
        uiElements.forEach { it.onDraw(renderer) }
    }

    override fun onRender() {
        renderUi()



        //val screen = renderer.getScreenSize()

//        renderer.drawRect(Pos(60, 60), Size(screen.w - 120,  screen.h - 120), Color.RED, 8)
//        renderer.drawLine(Pos(0, 0), Pos(screen.w, screen.h), Color.GREEN, 8)
//        renderer.drawImage(Pos(100, 100), Size(D.getBlockSize(), D.getBlockSize()), assetsManager.getImage("stone"))
//        renderer.fillRect(Pos(500, 500), Size(50, 50), Color.BLUE)
//        renderer.drawText(Pos(screen.w / 2, screen.h / 2), "Drawing Test", 16, Color.BLACK)
    }
}