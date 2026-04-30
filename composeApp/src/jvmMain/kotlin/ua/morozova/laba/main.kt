package ua.morozova.laba

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ua.morozova.laba.ui.root.AppScaffold

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Organise",
    ) {
        AppScaffold()
    }
}