package dev.vengateshm.kmpudemycourseapp.android.di

import app.cash.sqldelight.db.SqlDriver
import dev.vengateshm.kmpudemycourseapp.db.DatabaseDriverFactory
import dev.vengateshm.kmpudemycourseapp.db.getDatabaseBuilder
import dev.vengateshm.kmpudemycourseapp.room_db.AppRoomDatabase
import dev.vengateshm.kmpudemycourseapp.room_db.TodoDao
import dev.vengateshm.kmpudemycourseapp.room_db.getAppRoomDatabase
import dev.vengateshm.kmpudemycourseapp.room_db.getTodoDao
import dev.vengateshm.newsapp.db.NewsAppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

// Can reside in androidMain of shared module
val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single<NewsAppDatabase> { NewsAppDatabase(get()) }
    single<AppRoomDatabase> { getAppRoomDatabase(getDatabaseBuilder(androidContext())) }
    single<TodoDao> { getTodoDao(get()) }
}