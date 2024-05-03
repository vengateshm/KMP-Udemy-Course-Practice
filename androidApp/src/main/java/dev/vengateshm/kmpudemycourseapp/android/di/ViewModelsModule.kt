package dev.vengateshm.kmpudemycourseapp.android.di

import dev.vengateshm.kmpudemycourseapp.articles.presentation.ArticlesViewModel
import dev.vengateshm.kmpudemycourseapp.sources.presentation.SourcesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { ArticlesViewModel(get()) }
    viewModel { SourcesViewModel(get()) }
}