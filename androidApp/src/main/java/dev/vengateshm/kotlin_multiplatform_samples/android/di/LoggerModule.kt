package dev.vengateshm.kotlin_multiplatform_samples.android.di

import dev.vengateshm.kotlin_multiplatform_samples.AndroidAppLogger
import dev.vengateshm.kotlin_multiplatform_samples.AppLogger
import org.koin.dsl.module

val appLoggerModule = module {
    single<AppLogger> { AndroidAppLogger() }
}