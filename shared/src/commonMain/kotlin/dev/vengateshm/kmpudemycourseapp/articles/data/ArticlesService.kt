package dev.vengateshm.kmpudemycourseapp.articles.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val client: HttpClient) {
    private val country = "us"
    private val category = "business"
    private val apiKey = "bd54f205146e4b478e1b59d7a1f01264"

    suspend fun getArticles(): List<ArticleRaw> {
        val response =
            client.get("http://newsapi.org/v2/top-headlines?country=${country}&category=${category}&apiKey=${apiKey}")
                .body<ArticlesResponse>()
        return response.articles
    }
}