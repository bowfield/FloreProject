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

        appendUiElement(UIButton(Pos(20, 20), Size(160, 40), "Start"))
        appendUiElement(UIButton(Pos(20, 70), Size(160, 40), "Quit"))
    }

    fun appendUiElement(el: UIElement) {
        uiElements.add(el)
    }

    private fun renderUi() {
        uiElements.forEach { it.onDraw(renderer) }
    }

    override fun onRender() {
        renderUi()
    }
}