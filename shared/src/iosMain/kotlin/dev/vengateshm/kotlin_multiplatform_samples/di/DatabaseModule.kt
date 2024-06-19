package dev.vengateshm.kotlin_multiplatform_samples.di

import app.cash.sqldelight.db.SqlDriver
import dev.vengateshm.kotlin_multiplatform_samples.db.DatabaseDriverFactory
import dev.vengateshm.newsapp.db.NewsAppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<NewsAppDatabase> { NewsAppDatabase(get()) }
}