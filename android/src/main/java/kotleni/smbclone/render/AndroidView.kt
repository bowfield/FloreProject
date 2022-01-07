package kotleni.smbclone.render

import android.graphics.Canvas
import android.view.View
import kotleni.smbclone.MainActivity

class AndroidView(var activity: MainActivity): View(activity) {
    private var isFirst = true

    init {

    }

    override fun onDraw(canvas: Canvas) {
        if(isFirst) {
            activity.canvasInit(canvas)
            isFirst = false
        }

        activity.renderer.canvas = canvas
        activity.needRender()
    }
}