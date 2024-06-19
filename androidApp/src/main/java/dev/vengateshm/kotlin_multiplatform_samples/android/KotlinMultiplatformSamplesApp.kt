package dev.vengateshm.kotlin_multiplatform_samples.android

import android.app.Application
import dev.vengateshm.kotlin_multiplatform_samples.android.di.appLoggerModule
import dev.vengateshm.kotlin_multiplatform_samples.android.di.dataStoreModule
import dev.vengateshm.kotlin_multiplatform_samples.android.di.databaseModule
import dev.vengateshm.kotlin_multiplatform_samples.android.di.viewModelsModule
import dev.vengateshm.kotlin_multiplatform_samples.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class KotlinMultiplatformSamplesApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()

        Timber.plant(Timber.DebugTree())
    }

    private fun initKoin() {
        val modules = viewModelsModule + databaseModule + dataStoreModule + sharedKoinModules + appLoggerModule
        startKoin {
            androidContext(this@KotlinMultiplatformSamplesApp)
            modules(modules)
        }
    }
}