package kotleni.smbclone.render

import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Rect
import app.rateme.main.render.Renderer
import app.rateme.main.type.Color
import app.rateme.main.type.Image
import app.rateme.main.type.Pos
import app.rateme.main.type.Size
import kotleni.smbclone.type.AndroidImage

class AndroidRenderer(): Renderer() {
    private val paint = Paint()
        .apply {
            // disable all filtering
            isFilterBitmap = false
            isDither = false
            isAntiAlias = false
        }
    var canvas: Canvas? = null

    override fun drawRect(pos: Pos, size: Size, color: Color, strokeWidth: Int) {
        paint.color = android.graphics.Color.rgb(color.r, color.g, color.b)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = strokeWidth.toFloat()

        canvas?.drawRect(Rect(pos.x, pos.y, pos.x + size.w, pos.y + size.h), paint)
    }

    override fun drawLine(posA: Pos, posB: Pos, color: Color, strokeWidth: Int) {
        paint.color = android.graphics.Color.rgb(color.r, color.g, color.b)
        paint.strokeWidth = strokeWidth.toFloat()

        canvas?.drawLine(posA.x.toFloat(), posA.y.toFloat(), posB.x.toFloat(), posB.y.toFloat(), paint)
    }

    override fun drawImage(pos: Pos, size: Size, image: Image) {
        val androidImage = image as AndroidImage

        canvas?.drawBitmap(androidImage.bitmap,
            null,
            Rect(pos.x, pos.y, pos.x + size.w, pos.y + size.h),
            paint)
    }

    override fun drawText(pos: Pos, text: String, fontSize: Int, color: Color) {
        paint.color = android.graphics.Color.rgb(color.r, color.g, color.b)
        paint.textSize = fontSize.toFloat() * 2.1f

        canvas?.drawText(text, pos.x.toFloat(), pos.y.toFloat(), paint)
    }

    override fun fillRect(pos: Pos, size: Size, color: Color) {
        paint.color = android.graphics.Color.rgb(color.r, color.g, color.b)
        paint.style = Paint.Style.FILL

        canvas?.drawRect(Rect(pos.x, pos.y, pos.x + size.w, pos.y + size.h), paint)
    }
}