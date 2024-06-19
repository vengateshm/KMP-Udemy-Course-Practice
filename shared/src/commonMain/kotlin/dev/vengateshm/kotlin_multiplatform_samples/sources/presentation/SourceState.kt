package dev.vengateshm.kotlin_multiplatform_samples.sources.presentation

import dev.vengateshm.kotlin_multiplatform_samples.sources.domain.Source

data class SourceState(
    val sources: List<Source> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
