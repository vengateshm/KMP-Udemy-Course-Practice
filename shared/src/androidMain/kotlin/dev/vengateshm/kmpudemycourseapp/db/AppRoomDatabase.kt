package dev.vengateshm.kmpudemycourseapp.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.vengateshm.kmpudemycourseapp.room_db.AppRoomDatabase

fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<AppRoomDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("app_room.db")
    return Room.databaseBuilder<AppRoomDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}