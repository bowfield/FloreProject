package app.rateme.desktop

import app.rateme.desktop.type.DesktopImage
import app.rateme.main.render.Renderer
import app.rateme.main.type.Color
import app.rateme.main.type.Image
import app.rateme.main.type.Pos
import app.rateme.main.type.Size
import java.awt.BasicStroke
import java.awt.Font
import java.awt.Graphics2D
import javax.swing.JFrame

class DesktopRenderer(var frame: JFrame): Renderer() {
    override fun drawRect(pos: Pos, size: Size, color: Color, strokeWidth: Int) {
        frame.graphics?.let {
            val g2d = it as Graphics2D

            g2d.color = java.awt.Color(color.r, color.g, color.b)
            g2d.stroke = BasicStroke(strokeWidth.toFloat())
            g2d.drawRect(pos.x, pos.y, size.w, size.h)
        }
    }

    override fun drawLine(posA: Pos, posB: Pos, color: Color, strokeWidth: Int) {
        frame.graphics?.let {
            val g2d = it as Graphics2D

            g2d.color = java.awt.Color(color.r, color.g, color.b)
            g2d.stroke = BasicStroke(strokeWidth.toFloat())
            g2d.drawLine(posA.x, posA.x, posB.x, posB.y)
        }
    }

    override fun drawText(pos: Pos, text: String, fontSize: Int, color: Color) {
        frame.graphics?.let {
            val g2d = it as Graphics2D

            g2d.color = java.awt.Color(color.r, color.g, color.b)
            g2d.font = Font("monospace", Font.PLAIN, fontSize)
            g2d.drawString(text, pos.x, pos.y)
        }
    }

    override fun drawImage(pos: Pos, size: Size, image: Image) {
        val desktopImage = image as DesktopImage

        frame.graphics?.let {
            val g2d = it as Graphics2D

            g2d.drawImage(desktopImage.image, pos.x, pos.y, size.w, size.h, null)
        }
    }
}