package dev.vengateshm.kotlin_multiplatform_samples.sources.data

import kotlinx.serialization.Serializable

@Serializable
data class SourceResponse(
    val status: String,
    val sources: List<SourceRaw>
)