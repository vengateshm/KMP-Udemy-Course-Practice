package dev.vengateshm.kmpudemycourseapp.articles.presentation

import dev.vengateshm.kmpudemycourseapp.articles.domain.Article

data class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)