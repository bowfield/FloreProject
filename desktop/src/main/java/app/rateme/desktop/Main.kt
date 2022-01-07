package app.rateme.desktop

fun main() {
    // fix russian letters
    System.setProperty("file.encoding", "UTF-8")

    DesktopGame()
        .startGame()
}