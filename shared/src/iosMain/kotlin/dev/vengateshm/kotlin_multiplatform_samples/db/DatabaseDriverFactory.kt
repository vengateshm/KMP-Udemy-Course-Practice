package dev.vengateshm.kotlin_multiplatform_samples.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import dev.vengateshm.newsapp.db.NewsAppDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(
            schema = NewsAppDatabase.Schema,
            name = "NewsApp.Database.db"
        )
}