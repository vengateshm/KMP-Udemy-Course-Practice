package dev.vengateshm.kotlin_multiplatform_samples.sources.domain

import dev.vengateshm.kotlin_multiplatform_samples.sources.data.SourceRepository

class SourcesUseCase(private val sourceRepository: SourceRepository) {
    suspend fun getSources(): List<Source> {
        val articles = sourceRepository.getAllSources()
        return articles.map { it.toSource() }
    }
}