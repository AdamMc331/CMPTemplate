package template.shared.datetime

import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * This interface provides the current date time via the [now] function.
 *
 * The use of an interface allows us to create a fake implementation we can
 * supply for tests or debugging.
 */
@OptIn(ExperimentalTime::class)
interface DateTimeProvider {
    fun now(): Instant
}
