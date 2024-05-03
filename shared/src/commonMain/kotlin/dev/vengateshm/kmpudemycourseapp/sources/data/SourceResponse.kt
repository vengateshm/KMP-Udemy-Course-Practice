package dev.vengateshm.kmpudemycourseapp.sources.data

import kotlinx.serialization.Serializable

@Serializable
data class SourceResponse(
    val status: String,
    val sources: List<SourceRaw>
)