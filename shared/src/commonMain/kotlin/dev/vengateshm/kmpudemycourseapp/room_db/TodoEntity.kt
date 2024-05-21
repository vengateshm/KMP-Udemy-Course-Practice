package dev.vengateshm.kmpudemycourseapp.room_db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val content: String
)

val sampleTodos = listOf(
    TodoEntity(
        id = 1,
        title = "Buy Groceries",
        content = "Milk, Eggs, Bread, Butter"
    ),
    TodoEntity(
        id = 2,
        title = "Call Mom",
        content = "Check in and see how she's doing"
    ),
    TodoEntity(
        id = 3,
        title = "Finish Homework",
        content = "Complete the math and science assignments"
    ),
    TodoEntity(
        id = 4,
        title = "Workout",
        content = "Go for a 30-minute run and do strength training"
    ),
    TodoEntity(
        id = 5,
        title = "Read a Book",
        content = "Read at least 50 pages of the current novel"
    )
)