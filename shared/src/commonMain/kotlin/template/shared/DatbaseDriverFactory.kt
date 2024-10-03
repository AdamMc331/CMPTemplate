package template.shared

import app.cash.sqldelight.db.SqlDriver

/**
 * Interface to provide a SqlDelight [SqlDriver] instance. We will
 * need to define this per platform.
 */
interface DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}
