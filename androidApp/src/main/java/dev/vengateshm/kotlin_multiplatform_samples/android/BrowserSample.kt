package dev.vengateshm.kotlin_multiplatform_samples.android

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.vengateshm.kotlin_multiplatform_samples.openWebBrowser

@Composable
fun BrowserSample(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { openWebBrowser("https://developer.android.com") }) {
            Text(text = "Open")
        }
    }
}