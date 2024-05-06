package dev.vengateshm.kmpudemycourseapp.android.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import dev.vengateshm.kmpudemycourseapp.datastore.AppDatastore
import dev.vengateshm.kmpudemycourseapp.datastore.DatastoreFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single<DataStore<Preferences>> { DatastoreFactory(androidContext()).createDatastore() }
    single<AppDatastore> { AppDatastore(get()) }
}