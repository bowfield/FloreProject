package kotleni.smbclone

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import app.rateme.main.Game
import app.rateme.main.OS
import app.rateme.main.render.Renderer
import app.rateme.main.type.Color
import app.rateme.main.type.Pos
import app.rateme.main.type.Size
import kotleni.smbclone.render.AndroidRenderer
import kotleni.smbclone.render.AndroidView

class MainActivity : AppCompatActivity() {
    val renderer = AndroidRenderer()
    val assetsManager = AndroidAssetsManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        assetsManager.loadAll()
        setContentView(AndroidView(this))
    }

    fun canvasInit(canvas: Canvas) {
        // configuring render
        renderer.initRender1(
            Size(canvas.width, canvas.height)
        )

        Game(renderer, assetsManager)
            .initGame(
                OS.ANDROID
            )
    }

    fun needRender() {
        renderer.getRenderBroadcast().onRender()
    }
}



