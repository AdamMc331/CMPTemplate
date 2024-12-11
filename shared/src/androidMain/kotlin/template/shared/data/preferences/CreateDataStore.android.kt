package template.shared.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

/**
 * On Android, we create the [DataStore] implementation by looking up
 * the preference file using the supplied [appContext].
 */
fun createAndroidDataStore(appContext: Context): DataStore<Preferences> {
    return createDataStore(
        producePath = {
            appContext.filesDir.resolve(DATA_STORE_FILE_NAME).absolutePath
        },
    )
}
