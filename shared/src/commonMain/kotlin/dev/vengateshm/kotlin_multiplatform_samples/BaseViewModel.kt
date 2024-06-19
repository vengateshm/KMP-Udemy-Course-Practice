package dev.vengateshm.kotlin_multiplatform_samples

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {
    val scope: CoroutineScope
}