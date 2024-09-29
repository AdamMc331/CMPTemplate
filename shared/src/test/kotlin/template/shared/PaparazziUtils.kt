package template.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.cash.paparazzi.Paparazzi
import template.shared.theme.TemplateTheme

/**
 * This is a helper function that renders all of our content inside a box that takes up max space,
 * and also wraps it around our design system theme.
 */
fun Paparazzi.snapshotScreen(
    darkTheme: Boolean,
    screenPaddingDp: Int = 16,
    content: @Composable () -> Unit,
) {
    this.snapshot {
        TemplateTheme(
            darkTheme = darkTheme,
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(screenPaddingDp.dp),
                ) {
                    content()
                }
            }
        }
    }
}
