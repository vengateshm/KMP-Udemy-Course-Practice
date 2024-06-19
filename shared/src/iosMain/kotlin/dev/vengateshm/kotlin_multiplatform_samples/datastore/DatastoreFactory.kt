package dev.vengateshm.kotlin_multiplatform_samples.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import kotlinx.cinterop.ExperimentalForeignApi
import okio.Path.Companion.toPath
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

actual class DatastoreFactory {
    @OptIn(ExperimentalForeignApi::class)
    actual fun createDatastore(): DataStore<Preferences> {

        val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null
        )
        return PreferenceDataStoreFactory.createWithPath(
            produceFile = {
                (requireNotNull(documentDirectory).path + "/$dataStoreFileName").toPath()
            }
        )
    }
}