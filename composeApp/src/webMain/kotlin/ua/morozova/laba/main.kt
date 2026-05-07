package ua.morozova.laba

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import ua.morozova.laba.di.initKoin
import ua.morozova.laba.ui.root.AppScaffold

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin { printLogger() }
    ComposeViewport {
        AppScaffold()
    }
}