package dev.vengateshm.kotlin_multiplatform_samples.di

import dev.vengateshm.kotlin_multiplatform_samples.articles.presentation.ArticlesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {
    val modules = sharedKoinModules + databaseModule + dataStoreModule + appLoggerModule

    startKoin {
        modules(modules)
    }
}

class ArticlesInjector : KoinComponent {
    val articlesViewModel: ArticlesViewModel by inject()
}