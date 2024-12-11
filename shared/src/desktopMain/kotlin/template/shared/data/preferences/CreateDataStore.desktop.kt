package template.shared.data.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import template.shared.data.preferences.DATA_STORE_FILE_NAME
import template.shared.data.preferences.createDataStore

/**
 * On Desktop, we can create a [DataStore] implementation by referencing
 * the preference file directly.
 */
fun createDesktopDataStore(): DataStore<Preferences> {
    return createDataStore(
        producePath = {
            DATA_STORE_FILE_NAME
        },
    )
}
