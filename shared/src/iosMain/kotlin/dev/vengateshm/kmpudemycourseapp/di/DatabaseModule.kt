package dev.vengateshm.kmpudemycourseapp.di

import app.cash.sqldelight.db.SqlDriver
import dev.vengateshm.kmpudemycourseapp.db.DatabaseDriverFactory
import dev.vengateshm.newsapp.db.NewsAppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<NewsAppDatabase> { NewsAppDatabase(get()) }
}