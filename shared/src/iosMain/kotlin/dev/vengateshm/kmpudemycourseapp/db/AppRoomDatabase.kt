package dev.vengateshm.kmpudemycourseapp.db

import androidx.room.Room
import androidx.room.RoomDatabase
import dev.vengateshm.kmpudemycourseapp.room_db.AppRoomDatabase
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): RoomDatabase.Builder<AppRoomDatabase> {
    val dbFilePath = NSHomeDirectory() + "/app_room.db"
    return Room.databaseBuilder<AppRoomDatabase>(
        name = dbFilePath,
        factory =  { AppRoomDatabase::class.instantiateImpl() }
    )
}