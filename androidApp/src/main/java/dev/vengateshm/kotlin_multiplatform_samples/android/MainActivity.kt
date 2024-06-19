package dev.vengateshm.kotlin_multiplatform_samples.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import dev.vengateshm.kotlin_multiplatform_samples.AppLogger
import dev.vengateshm.kotlin_multiplatform_samples.datastore.AppDatastore
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val appDatastore: AppDatastore by inject()
    private val appLogger: AppLogger by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val articlesViewModel : ArticlesViewModel by viewModels()

        setContent {

            val isDarkTheme by appDatastore.isDarkTheme().collectAsState(initial = false)

            MyApplicationTheme(
                darkTheme = isDarkTheme
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    AppScaffold(articlesViewModel = null)
                    BrowserSample()
                    appLogger.log("Logger logging something...")
                }
            }
        }
    }
}