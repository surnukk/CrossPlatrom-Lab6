package ua.morozova.laba

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ua.morozova.laba.ui.root.AppScaffold
import ua.morozova.laba.di.initKoin

fun main() = application {
    initKoin { printLogger() }
    Window(
        onCloseRequest = ::exitApplication,
        title = "Organise",
    ) {
        AppScaffold()
    }
}