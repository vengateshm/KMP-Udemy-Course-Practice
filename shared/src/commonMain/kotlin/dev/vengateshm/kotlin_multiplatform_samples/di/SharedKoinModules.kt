package dev.vengateshm.kotlin_multiplatform_samples.di

import dev.vengateshm.kotlin_multiplatform_samples.articles.di.articlesModule
import dev.vengateshm.kotlin_multiplatform_samples.sources.di.sourcesModule

val sharedKoinModules = listOf(
    networkModule,
    articlesModule,
    sourcesModule
)