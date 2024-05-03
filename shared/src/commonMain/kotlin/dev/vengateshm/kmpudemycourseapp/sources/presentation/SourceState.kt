package dev.vengateshm.kmpudemycourseapp.sources.presentation

import dev.vengateshm.kmpudemycourseapp.sources.domain.Source

data class SourceState(
    val sources: List<Source> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
