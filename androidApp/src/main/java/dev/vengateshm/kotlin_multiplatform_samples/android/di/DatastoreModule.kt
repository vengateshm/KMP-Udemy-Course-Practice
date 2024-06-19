package dev.vengateshm.kotlin_multiplatform_samples.android.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import dev.vengateshm.kotlin_multiplatform_samples.datastore.AppDatastore
import dev.vengateshm.kotlin_multiplatform_samples.datastore.DatastoreFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single<DataStore<Preferences>> { DatastoreFactory(androidContext()).createDatastore() }
    single<AppDatastore> { AppDatastore(get()) }
}