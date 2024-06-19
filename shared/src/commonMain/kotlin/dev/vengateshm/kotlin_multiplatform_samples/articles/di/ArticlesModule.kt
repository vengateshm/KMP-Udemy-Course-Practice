package dev.vengateshm.kotlin_multiplatform_samples.articles.di

import dev.vengateshm.kotlin_multiplatform_samples.articles.data.ArticleRepository
import dev.vengateshm.kotlin_multiplatform_samples.articles.data.ArticlesDataSource
import dev.vengateshm.kotlin_multiplatform_samples.articles.data.ArticlesService
import dev.vengateshm.kotlin_multiplatform_samples.articles.domain.ArticlesUseCase
import dev.vengateshm.kotlin_multiplatform_samples.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get(), get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticleRepository> { ArticleRepository(get(), get()) }
}