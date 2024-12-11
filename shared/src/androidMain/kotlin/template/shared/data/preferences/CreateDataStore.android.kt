package template.shared.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

fun createAndroidDataStore(context: Context): DataStore<Preferences> {
    return createDataStore(
        producePath = {
            context.filesDir.resolve(DATA_STORE_FILE_NAME).absolutePath
        },
    )
}
