package dev.vengateshm.kotlin_multiplatform_samples.articles.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticlesResponse(
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val results: Int,
    val articles: List<ArticleRaw>
)
