package dev.vengateshm.kmpudemycourseapp.android.room_db

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.vengateshm.kmpudemycourseapp.room_db.TodoDao
import dev.vengateshm.kmpudemycourseapp.room_db.TodoEntity
import dev.vengateshm.kmpudemycourseapp.room_db.sampleTodos
import kotlin.random.Random

@Composable
fun TodoListScreen(modifier: Modifier = Modifier, todoDao: TodoDao) {

    val todos by todoDao.getAllAsFlow().collectAsState(initial = emptyList())

    LaunchedEffect(key1 = true) {
        sampleTodos.forEach {
            todoDao.insert(it)
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(todos) { todo ->
            TodoItem(todo)
        }
    }
}

@Composable
fun TodoItem(todo: TodoEntity) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(
                brush = gradientBrushes[Random.nextInt(gradientBrushes.size)],
                shape = RoundedCornerShape(8.dp)
            )
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(12.dp),
                clip = false
            )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = todo.title,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontSize = 20.sp,
                    color = Color.White
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = todo.content,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    color = Color.White
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoItemPreview() {
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
    TodoItem(todo = sampleTodos.take(1).first())
}

val gradientBrushes = listOf(
    Brush.linearGradient(
        colors = listOf(
            Color(0xFF2196F3),
            Color(0xFF21CBF3)
        )
    ),
    Brush.linearGradient(
        colors = listOf(
            Color(0xFFFFA726),
            Color(0xFFFF7043)
        )
    ),
    Brush.linearGradient(
        colors = listOf(
            Color(0xFF66BB6A),
            Color(0xFF43A047)
        )
    ),
    Brush.linearGradient(
        colors = listOf(
            Color(0xFFAB47BC),
            Color(0xFF8E24AA)
        )
    ),
    Brush.linearGradient(
        colors = listOf(
            Color(0xFFEF5350),
            Color(0xFFE53935)
        )
    )
)