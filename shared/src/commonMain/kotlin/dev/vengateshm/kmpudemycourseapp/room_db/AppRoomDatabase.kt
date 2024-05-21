package dev.vengateshm.kmpudemycourseapp.room_db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(entities = [TodoEntity::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun getDao(): TodoDao
}

fun getAppRoomDatabase(
    builder: RoomDatabase.Builder<AppRoomDatabase>
): AppRoomDatabase {
    return builder
        .fallbackToDestructiveMigrationOnDowngrade(false)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}

fun getTodoDao(database: AppRoomDatabase) = database.getDao()