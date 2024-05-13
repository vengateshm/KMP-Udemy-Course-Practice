package dev.vengateshm.kmpudemycourseapp

import android.content.Context
import androidx.startup.Initializer

internal var androidContext: Context? = null
    private set

object AppContext

class AppContextInitializer : Initializer<AppContext> {
    override fun create(context: Context): AppContext {
        androidContext = context
        return AppContext
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}