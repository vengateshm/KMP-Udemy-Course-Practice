package dev.vengateshm.kotlin_multiplatform_samples.android.di

import app.cash.sqldelight.db.SqlDriver
import dev.vengateshm.kotlin_multiplatform_samples.db.DatabaseDriverFactory
import dev.vengateshm.newsapp.db.NewsAppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

// Can reside in androidMain of shared module
val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single<NewsAppDatabase> { NewsAppDatabase(get()) }
}