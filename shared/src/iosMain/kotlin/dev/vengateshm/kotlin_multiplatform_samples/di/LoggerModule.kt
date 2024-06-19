package dev.vengateshm.kotlin_multiplatform_samples.di

import dev.vengateshm.kotlin_multiplatform_samples.IOSAppLogger
import dev.vengateshm.kotlin_multiplatform_samples.AppLogger
import org.koin.dsl.module

val appLoggerModule = module {
    single<AppLogger> { IOSAppLogger() }
}