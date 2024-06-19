package dev.vengateshm.kotlin_multiplatform_samples.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import dev.vengateshm.kotlin_multiplatform_samples.datastore.DatastoreFactory
import org.koin.dsl.module

val dataStoreModule = module {
    single<DataStore<Preferences>> { DatastoreFactory(get()).createDatastore() }
}