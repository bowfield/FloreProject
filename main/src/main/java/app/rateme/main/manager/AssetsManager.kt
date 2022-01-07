package app.rateme.main.manager

import app.rateme.main.type.Image

open class AssetsManager {
    val images: HashMap<String, Image> = HashMap()

    fun getImage(name: String): Image {
        return images.get("$name.png")!!
    }

    open fun loadAll() { }
}