package template.shared

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

/**
 * Create an instance of a [SqlDriver] for the iOS platform.
 */
class IOSDatabaseDriverFactory : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver = NativeSqliteDriver(TODO("Define AppDatabase.schema"), "TODO.db")
}
