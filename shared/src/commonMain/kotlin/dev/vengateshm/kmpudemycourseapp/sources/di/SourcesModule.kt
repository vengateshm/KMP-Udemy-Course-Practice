package dev.vengateshm.kmpudemycourseapp.sources.di

import dev.vengateshm.kmpudemycourseapp.sources.data.SourceDataSource
import dev.vengateshm.kmpudemycourseapp.sources.data.SourceRepository
import dev.vengateshm.kmpudemycourseapp.sources.data.SourcesService
import dev.vengateshm.kmpudemycourseapp.sources.domain.SourcesUseCase
import dev.vengateshm.kmpudemycourseapp.sources.presentation.SourcesViewModel
import org.koin.dsl.module

val sourcesModule = module {
    single<SourcesService> { SourcesService(get()) }
    single<SourcesUseCase> { SourcesUseCase(get()) }
    single<SourcesViewModel> { SourcesViewModel(get()) }
    single<SourceDataSource> { SourceDataSource(get()) }
    single<SourceRepository> { SourceRepository(get(), get()) }
}