package ua.morozova.laba.data.about

import co.touchlab.kermit.Logger
import kotlinx.browser.window
import ua.morozova.laba.parseBrowserName
import ua.morozova.laba.parseBrowserVersion
import ua.morozova.laba.parseLayoutEngine
import ua.morozova.laba.parseOsName
import ua.morozova.laba.parseOsVersion

actual open class Platform actual constructor() {
    actual val osName: String
        get() = parseBrowserName(window.navigator.userAgent)
    actual val osVersion: String
        get() = parseBrowserVersion(window.navigator.userAgent)
    actual val deviceModel: String
        get() = parseOsName(window.navigator.userAgent) + " " + parseOsVersion(window.navigator.userAgent)
    actual val cpuType: String
        get() = parseLayoutEngine(window.navigator.userAgent)
    actual val screen: ScreenInfo
        get() = ScreenInfo()

    actual fun logSystemInfo() {
        Logger.d("Platform $deviceInfo")
    }
}

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class ScreenInfo actual constructor() {

    val pageWidth = window.innerWidth
    val pageHeight = window.innerHeight
    val deviceDensity = window.devicePixelRatio

    actual val width: Int
        get() = pageWidth
    actual val height: Int
        get() = pageHeight
    actual val density: Int?
        get() = deviceDensity.toInt()
}