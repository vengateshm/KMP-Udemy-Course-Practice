package dev.vengateshm.kotlin_multiplatform_samples.articles.data

import dev.vengateshm.kotlin_multiplatform_samples.articles.domain.Article
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleRaw(
    val title: String,
    val description: String?,
    val publishedAt: String,
    @SerialName("urlToImage")
    val imageUrl: String?,
) {
    fun toArticle() = Article(
        title = title,
        desc = description ?: "Click to find out more",
        date = publishedAt,
        imageUrl = imageUrl
            ?: "https://image.cnbcfm.com/api/v1/image/107409760-1714683259133-gettyimages-1980125871-_s1_6160_kqcjkjrg.jpeg?v=1714683304&w=1920&h=1080"
    )
}

