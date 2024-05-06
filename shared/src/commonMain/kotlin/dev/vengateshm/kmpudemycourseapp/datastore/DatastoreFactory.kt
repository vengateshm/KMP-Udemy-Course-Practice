package dev.vengateshm.kmpudemycourseapp.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

expect class DatastoreFactory {
    fun createDatastore(): DataStore<Preferences>
}

internal const val dataStoreFileName = "newsapp.preferences_pb"