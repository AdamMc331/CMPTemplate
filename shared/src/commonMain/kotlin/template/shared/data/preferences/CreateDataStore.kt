package template.shared.data.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

/**
 * Platform agnostic function to create a [DataStore] instance.
 *
 * @param[producePath] A lambda to create a path to the preference file.
 *  This is provided as the path to the file is platform specific.
 */
fun createDataStore(
    producePath: () -> String,
): DataStore<Preferences> {
    return PreferenceDataStoreFactory.createWithPath(
        produceFile = { producePath().toPath() },
    )
}

const val DATA_STORE_FILE_NAME = "TODO.preferences_pb"
