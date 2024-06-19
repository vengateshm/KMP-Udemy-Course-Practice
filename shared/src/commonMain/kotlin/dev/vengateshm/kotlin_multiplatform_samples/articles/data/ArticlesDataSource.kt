package dev.vengateshm.kotlin_multiplatform_samples.articles.data

import dev.vengateshm.newsapp.db.NewsAppDatabase

class ArticlesDataSource(private val database: NewsAppDatabase) {
    fun getAllArticles(): List<ArticleRaw> =
        database.newsAppDatabaseQueries.selectAllArticles(::mapToArticleRaw).executeAsList()

    fun insertArticles(articlesRaw: List<ArticleRaw>) {
        database.newsAppDatabaseQueries.run {
            transaction {
                articlesRaw.forEach { articleRaw ->
                    with(articleRaw) {
                        insertArticle(title, description, publishedAt, imageUrl)
                    }
                }
            }
        }
    }

    fun deleteArticles() {
        database.newsAppDatabaseQueries.removeAllArticles()
    }

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        imageUrl: String?
    ): ArticleRaw = ArticleRaw(
        title = title, description = desc, publishedAt = date, imageUrl = imageUrl
    )
}