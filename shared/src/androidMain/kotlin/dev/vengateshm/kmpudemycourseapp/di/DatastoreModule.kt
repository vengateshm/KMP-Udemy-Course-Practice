package dev.vengateshm.kmpudemycourseapp.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import dev.vengateshm.kmpudemycourseapp.datastore.DatastoreFactory
import org.koin.dsl.module

val dataStoreModule = module {
    single<DataStore<Preferences>> { DatastoreFactory(get()).createDatastore() }
}