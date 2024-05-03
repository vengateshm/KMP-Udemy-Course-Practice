package dev.vengateshm.kmpudemycourseapp.sources.domain

import dev.vengateshm.kmpudemycourseapp.sources.data.SourceRepository

class SourcesUseCase(private val sourceRepository: SourceRepository) {
    suspend fun getSources(): List<Source> {
        val articles = sourceRepository.getAllSources()
        return articles.map { it.toSource() }
    }
}