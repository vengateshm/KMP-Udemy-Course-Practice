package dev.vengateshm.kmpudemycourseapp.sources.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourcesService(private val client: HttpClient) {
    private val apiKey = "bd54f205146e4b478e1b59d7a1f01264"

    suspend fun getSources(): List<SourceRaw> {
        val response =
            client.get("http://newsapi.org/v2/top-headlines/sources?apiKey=${apiKey}")
                .body<SourceResponse>()
        return response.sources
    }
}