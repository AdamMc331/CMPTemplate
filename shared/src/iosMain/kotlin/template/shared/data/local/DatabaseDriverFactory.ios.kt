@file:Suppress("ktlint:standard:filename")

package template.shared.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import template.shared.AppDatabase

/**
 * Create an instance of a [SqlDriver] for the iOS platform.
 */
class IOSDatabaseDriverFactory : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            schema = AppDatabase.Schema,
            name = "TODO.db",
        )
    }
}
