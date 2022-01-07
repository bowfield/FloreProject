package app.rateme.main.ui

import app.rateme.main.render.Renderer
import app.rateme.main.type.Color
import app.rateme.main.type.Pos

class UIText(var pos: Pos, var text: String): UIElement() {
    override fun onDraw(renderer: Renderer) {
        renderer.drawText(pos, text, 16, Color.BLACK)
    }
}