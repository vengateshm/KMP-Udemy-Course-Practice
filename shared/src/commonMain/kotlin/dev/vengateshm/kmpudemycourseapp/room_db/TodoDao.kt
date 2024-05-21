package dev.vengateshm.kmpudemycourseapp.room_db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: TodoEntity)

    @Query("SELECT count(*) FROM TodoEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM TodoEntity")
    fun getAllAsFlow(): Flow<List<TodoEntity>>
}