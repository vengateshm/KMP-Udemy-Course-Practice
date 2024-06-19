package dev.vengateshm.kotlin_multiplatform_samples

import timber.log.Timber

class AndroidAppLogger: AppLogger {
    override fun log(msg: String) {
        Timber.d(msg)
    }
}