package template.shared.datetime

import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * Custom implementation of [DateTimeProvider] that will return the
 * current time from the system.
 */
@OptIn(ExperimentalTime::class)
class SystemDateTimeProvider : DateTimeProvider {
    override fun now(): Instant {
        return Clock.System.now()
    }
}
