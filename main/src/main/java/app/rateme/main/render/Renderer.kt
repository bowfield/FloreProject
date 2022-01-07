package app.rateme.main.render

import app.rateme.main.type.Color
import app.rateme.main.type.Image
import app.rateme.main.type.Pos
import app.rateme.main.type.Size

open class Renderer() {
    private var renderBroadcast: RenderBroadcast? = null
    private var screenSize = Size(0, 0)

    // 1 stage initialization
    fun initRender1(_screenSize: Size) {
        screenSize = _screenSize
    }

    // 2 stage initialization
    fun initRender2(broadcast: RenderBroadcast) {
        renderBroadcast = broadcast
    }

    fun getRenderBroadcast(): RenderBroadcast {
        return renderBroadcast!!
    }

    fun getScreenSize(): Size {
        return screenSize
    }

    open fun drawRect(pos: Pos, size: Size, color: Color, strokeWidth: Int) { }
    open fun drawLine(posA: Pos, posB: Pos, color: Color, strokeWidth: Int) { }
    open fun drawImage(pos: Pos, size: Size, image: Image) { }
    open fun drawText(pos: Pos, text: String, fontSize: Int, color: Color) { }
    open fun drawTextInRect(pos: Pos, size: Size, text: String, fontSize: Int, color: Color) { }
    open fun fillRect(pos: Pos, size: Size, color: Color) { }
}