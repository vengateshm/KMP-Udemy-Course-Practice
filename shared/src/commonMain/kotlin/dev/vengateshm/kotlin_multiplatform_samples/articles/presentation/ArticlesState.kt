package dev.vengateshm.kotlin_multiplatform_samples.articles.presentation

import dev.vengateshm.kotlin_multiplatform_samples.articles.domain.Article

data class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)