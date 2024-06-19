package dev.vengateshm.kotlin_multiplatform_samples.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.vengateshm.kotlin_multiplatform_samples.Platform

@Composable
fun AboutScreen(onUpButtonClick: () -> Boolean) {
    Column {
        Toolbar()
        ContentView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar() {
    TopAppBar(title = { Text(text = "About Device") })
}

@Composable
private fun ContentView() {
    val items = remember {
        makeItems()
    }
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items) { item ->
            RowView(title = item.first, subTitle = item.second)
        }
    }
}

@Composable
private fun RowView(title: String, subTitle: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = subTitle,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

private fun makeItems(): List<Pair<String, String>> {
    val platform = Platform()

    return listOf(
        "Operating System" to "${platform.osName} ${platform.osVersion}",
        "Device" to platform.deviceModel,
        "Density" to platform.density.toString()
    )
}