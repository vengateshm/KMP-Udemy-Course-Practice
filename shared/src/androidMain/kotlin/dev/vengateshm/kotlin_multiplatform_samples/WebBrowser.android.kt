package dev.vengateshm.kotlin_multiplatform_samples

import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent

actual fun openWebBrowser(url: String): Boolean {
    val intent: CustomTabsIntent = CustomTabsIntent.Builder().build().apply {
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }
    return if (androidContext != null) {
        intent.launchUrl(androidContext!!, Uri.parse(url))
        true
    } else false
}