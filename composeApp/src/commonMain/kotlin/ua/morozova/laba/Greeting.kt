package ua.morozova.laba

import ua.morozova.laba.data.about.Platform

class Greeting {
    private val platform = Platform()

    fun greet(): String {
        return "Hello, ${platform.osName}!"
    }
}