package dev.vengateshm.kmpudemycourseapp.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.vengateshm.kmpudemycourseapp.android.custom_composables.ErrorMessage
import dev.vengateshm.kmpudemycourseapp.android.custom_composables.Loader
import dev.vengateshm.kmpudemycourseapp.android.custom_composables.TitleOnlyAppBar
import dev.vengateshm.kmpudemycourseapp.sources.domain.Source
import dev.vengateshm.kmpudemycourseapp.sources.presentation.SourcesViewModel

@Composable
fun SourcesScreen(sourcesViewModel: SourcesViewModel) {
    val sourceState by sourcesViewModel.sourcesState.collectAsState()

    Column {
        TitleOnlyAppBar(title = "Sources")

        if (sourceState.loading)
            Loader()
        if (sourceState.error != null)
            ErrorMessage(sourceState.error!!)
        if (sourceState.sources.isNotEmpty())
            SourceListView(sources = sourceState.sources)
    }
}

@Composable
fun SourceListView(sources: List<Source>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(sources) { source ->
            SourceItemView(source = source)
        }
    }
}

@Composable
fun SourceItemView(modifier: Modifier = Modifier, source: Source) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = source.name,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = source.description)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier.align(Alignment.End),
            text = source.origin,
            style = TextStyle(color = Color.Gray),
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}