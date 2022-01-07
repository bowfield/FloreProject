package app.rateme.main.ui

import app.rateme.main.render.Renderer
import app.rateme.main.type.Pos

enum class InputType {
    TOUCH_CLICK,
    KEY_PRESS
}

open class UIElement {
    open fun onDraw(renderer: Renderer) { }
    open fun onInput(type: InputType) { }
}