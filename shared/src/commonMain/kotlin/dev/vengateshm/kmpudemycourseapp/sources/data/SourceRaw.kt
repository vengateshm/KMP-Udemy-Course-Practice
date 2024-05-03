package dev.vengateshm.kmpudemycourseapp.sources.data

import dev.vengateshm.kmpudemycourseapp.sources.domain.Source
import kotlinx.serialization.Serializable

@Serializable
data class SourceRaw(
    val id: String,
    val name: String,
    val description: String,
    val language: String,
    val country: String,
) {
    fun toSource() = Source(
        id = id,
        name = name,
        description = description,
        origin = "$country - $language"
    )
}
