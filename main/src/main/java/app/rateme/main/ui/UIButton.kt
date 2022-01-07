package app.rateme.main.ui

import app.rateme.main.render.Renderer
import app.rateme.main.type.Color
import app.rateme.main.type.Pos
import app.rateme.main.type.Size
import org.w3c.dom.Text

class UIButton(val pos: Pos, val size: Size, var text: String): UIElement() {
    override fun onDraw(renderer: Renderer) {
        renderer.drawRect(pos, size, Color.BLACK, 2)
        renderer.drawTextInRect(pos, size, text, 16, Color.BLACK)
    }
}