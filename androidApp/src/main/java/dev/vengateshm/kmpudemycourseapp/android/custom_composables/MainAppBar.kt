package dev.vengateshm.kmpudemycourseapp.android.custom_composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(
    onAboutButtonClick: () -> Unit,
    onSourceButtonClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "Articles") },
        actions = {
            IconButton(onClick = onSourceButtonClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.List,
                    contentDescription = "Source List Button",
                )
            }
            IconButton(onClick = onAboutButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "About Device Button",
                )
            }
        }
    )
}