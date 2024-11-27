package template

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import template.shared.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KotlinProject",
    ) {
        App()
    }
}
