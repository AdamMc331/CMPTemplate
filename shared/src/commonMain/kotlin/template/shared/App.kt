package template.shared

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import template.shared.ui.UiImage
import template.shared.ui.components.ImageWrapper
import template.shared.ui.theme.TemplateTheme

@Preview
@Composable
fun App() {
    TemplateTheme {
        var showContent by remember {
            mutableStateOf(false)
        }

        Surface {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Button(
                    onClick = {
                        showContent = !showContent
                    },
                ) {
                    Text(
                        text = "Click me!",
                    )
                }

                AnimatedVisibility(showContent) {
                    val greeting = remember {
                        Greeting().greet()
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {
                        ImageWrapper(
                            image = UiImage.Local(Res.drawable.compose_multiplatform),
                            contentDescription = null,
                        )
                        Text(
                            text = "Compose: $greeting",
                        )
                    }
                }
            }
        }
    }
}
