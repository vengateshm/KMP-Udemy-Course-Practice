package dev.vengateshm.kotlin_multiplatform_samples.android.di

import dev.vengateshm.kotlin_multiplatform_samples.articles.presentation.ArticlesViewModel
import dev.vengateshm.kotlin_multiplatform_samples.sources.presentation.SourcesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { ArticlesViewModel(get(), get()) }
    viewModel { SourcesViewModel(get()) }
}