package dev.vengateshm.kotlin_multiplatform_samples.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import dev.vengateshm.newsapp.db.NewsAppDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(
            schema = NewsAppDatabase.Schema,
            context = context,
            name = "NewsApp.Database.db"
        )
}