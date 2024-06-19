package dev.vengateshm.kotlin_multiplatform_samples.android.custom_composables

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleOnlyAppBar(title: String) {
    TopAppBar(
        title = { Text(text = title) },
        actions = { }
    )
}