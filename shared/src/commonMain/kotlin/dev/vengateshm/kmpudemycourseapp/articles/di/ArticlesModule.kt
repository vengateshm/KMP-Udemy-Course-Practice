package dev.vengateshm.kmpudemycourseapp.articles.di

import dev.vengateshm.kmpudemycourseapp.articles.data.ArticleRepository
import dev.vengateshm.kmpudemycourseapp.articles.data.ArticlesDataSource
import dev.vengateshm.kmpudemycourseapp.articles.data.ArticlesService
import dev.vengateshm.kmpudemycourseapp.articles.domain.ArticlesUseCase
import dev.vengateshm.kmpudemycourseapp.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get(), get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticleRepository> { ArticleRepository(get(), get()) }
}