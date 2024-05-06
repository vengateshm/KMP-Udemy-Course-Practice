package dev.vengateshm.kmpudemycourseapp.android.custom_composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(
    onAboutButtonClick: () -> Unit,
    onSourceButtonClick: () -> Unit,
    onCheck: (Boolean) -> Unit
) {
    var isDarkTheme by remember { mutableStateOf(false) }

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
            IconToggleButton(
                checked = isDarkTheme,
                onCheckedChange = {
                    isDarkTheme = !isDarkTheme
                    onCheck(!isDarkTheme)
                }) {
                if (isDarkTheme) {
                    Icon(Icons.Filled.Settings, contentDescription = "Localized description")
                } else {
                    Icon(Icons.Outlined.Settings, contentDescription = "Localized description")
                }
            }
        }
    )
}