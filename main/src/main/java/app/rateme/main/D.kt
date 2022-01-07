package app.rateme.main

object D {
    private var currentOS: OS = OS.UNKNOWN

    fun initD(os: OS) {
        currentOS = os

        D.logln("initialized from ${getCurrentOS().name}")
    }

    fun getCurrentOS(): OS {
        return currentOS
    }

    fun logln(line: String) {
        println("[Logger] $line")
    }

    fun getRenderScale(): Int {
        return when(getCurrentOS()) {
            OS.ANDROID -> 4

            else -> 1 // default
        }
    }
}