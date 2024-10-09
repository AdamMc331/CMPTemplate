package template.shared

import androidx.compose.runtime.Composable
import app.cash.paparazzi.Paparazzi
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import org.junit.Rule
import org.junit.runner.RunWith

/**
 * This base class allows us to write Paparazzi tests that validate composable content in both light and dark theme
 * using a parameterized test. Just extend this base class and call [snapshot] with your composable content.
 */
@RunWith(TestParameterInjector::class)
abstract class BasePaparazziTest {
    @get:Rule
    val paparazzi = Paparazzi()

    @TestParameter
    val useDarkTheme: Boolean = false

    /**
     * Validates the supplied [content] in both light and dark theme.
     */
    fun snapshot(content: @Composable () -> Unit) {
        paparazzi.snapshotScreen(useDarkTheme) {
            content()
        }
    }
}
