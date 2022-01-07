package kotleni.smbclone

import android.content.Context
import app.rateme.main.manager.AssetsManager
import android.graphics.BitmapFactory

import android.graphics.Bitmap

import android.content.res.AssetManager
import app.rateme.main.D
import app.rateme.main.Game
import kotleni.smbclone.type.AndroidImage
import java.io.IOException
import java.io.InputStream


class AndroidAssetsManager(var context: Context): AssetsManager() {
    fun getBitmapFromAsset(filePath: String): Bitmap {
        val assetManager: AssetManager = context.getAssets()
        val istr: InputStream
        var bitmap: Bitmap? = null
        try {
            istr = assetManager.open(filePath!!)
            bitmap = BitmapFactory.decodeStream(istr)
        } catch (e: IOException) { }
        return bitmap!!
    }

    override fun loadAll() {
        val assets = context.assets.list("")
        assets?.forEach {
            if(it.endsWith(".png")) {
                D.logln("Loading asset $it")
                val bitmap = getBitmapFromAsset(it)

                images?.put(it, AndroidImage(bitmap))
            }
        }
    }
}