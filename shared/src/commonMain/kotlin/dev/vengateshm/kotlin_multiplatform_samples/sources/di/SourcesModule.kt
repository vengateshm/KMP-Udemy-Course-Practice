package dev.vengateshm.kotlin_multiplatform_samples.sources.di

import dev.vengateshm.kotlin_multiplatform_samples.sources.data.SourceDataSource
import dev.vengateshm.kotlin_multiplatform_samples.sources.data.SourceRepository
import dev.vengateshm.kotlin_multiplatform_samples.sources.data.SourcesService
import dev.vengateshm.kotlin_multiplatform_samples.sources.domain.SourcesUseCase
import dev.vengateshm.kotlin_multiplatform_samples.sources.presentation.SourcesViewModel
import org.koin.dsl.module

val sourcesModule = module {
    single<SourcesService> { SourcesService(get()) }
    single<SourcesUseCase> { SourcesUseCase(get()) }
    single<SourcesViewModel> { SourcesViewModel(get()) }
    single<SourceDataSource> { SourceDataSource(get()) }
    single<SourceRepository> { SourceRepository(get(), get()) }
}