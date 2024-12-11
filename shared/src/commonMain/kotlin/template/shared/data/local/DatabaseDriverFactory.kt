package template.shared.data.local

import app.cash.sqldelight.db.SqlDriver

/**
 * Interface to provide a SqlDelight [SqlDriver] instance. We will need to define this per platform.
 *
 * Note that the template does not provide a way to enforce/supply the implementation in common code. Whether
 * you convert this to an expect/actual interface, or use DI to provide this dependency is up to you.
 */
interface DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}
