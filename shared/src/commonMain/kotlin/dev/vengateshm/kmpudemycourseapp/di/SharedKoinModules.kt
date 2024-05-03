package dev.vengateshm.kmpudemycourseapp.di

import dev.vengateshm.kmpudemycourseapp.articles.di.articlesModule
import dev.vengateshm.kmpudemycourseapp.sources.di.sourcesModule

val sharedKoinModules = listOf(
    networkModule,
    articlesModule,
    sourcesModule
)