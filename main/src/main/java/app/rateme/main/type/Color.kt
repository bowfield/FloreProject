package app.rateme.main.type

data class Color(val r: Int, val g: Int, val b: Int) {
    companion object {
        val RED = Color(255, 0, 0)
        val GREEN = Color(0, 255, 0)
        val BLUE = Color(0, 0, 255)
        val BLACK = Color(0, 0, 0)
        val WHITE = Color(255, 255, 255)
    }
}
