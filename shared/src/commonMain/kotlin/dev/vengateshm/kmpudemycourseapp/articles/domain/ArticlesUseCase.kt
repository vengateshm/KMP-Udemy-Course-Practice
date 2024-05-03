package dev.vengateshm.kmpudemycourseapp.articles.domain

import dev.vengateshm.kmpudemycourseapp.articles.data.ArticleRepository
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticlesUseCase(private val articleRepository: ArticleRepository) {
    suspend fun getArticles(forceFetch: Boolean): List<Article> {
        val articles = articleRepository.getArticles(forceFetch)
        return articles.map { it.toArticle().copy(date = getDaysAgoString(it.publishedAt)) }
    }

    private fun getDaysAgoString(date: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        return when {
            abs(days) > 1 -> "${abs(days)}days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }
    }
}