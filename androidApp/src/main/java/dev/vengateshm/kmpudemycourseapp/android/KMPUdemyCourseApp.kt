package dev.vengateshm.kmpudemycourseapp.android

import android.app.Application
import dev.vengateshm.kmpudemycourseapp.android.di.databaseModule
import dev.vengateshm.kmpudemycourseapp.android.di.viewModelsModule
import dev.vengateshm.kmpudemycourseapp.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KMPUdemyCourseApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        val modules = viewModelsModule + databaseModule + sharedKoinModules
        startKoin {
            androidContext(this@KMPUdemyCourseApp)
            modules(modules)
        }
    }
}