package app.rateme.desktop

import app.rateme.desktop.type.DesktopImage
import app.rateme.main.manager.AssetsManager
import java.io.File
import javax.imageio.ImageIO

class DesktopAssetsManager(): AssetsManager() {
    override fun loadAll() {
        val dir = File("./android/src/main/assets/")
        dir.listFiles().forEach {
            if(it.name.contains(".png")) {
                val image = ImageIO.read(it)

                images?.put(it.name, DesktopImage(image))
            }
        }
    }
}