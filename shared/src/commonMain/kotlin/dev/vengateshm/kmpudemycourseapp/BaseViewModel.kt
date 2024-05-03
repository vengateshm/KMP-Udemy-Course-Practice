package dev.vengateshm.kmpudemycourseapp

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {
    val scope: CoroutineScope
}