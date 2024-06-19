package dev.vengateshm.kotlin_multiplatform_samples.sources.data

import dev.vengateshm.newsapp.db.NewsAppDatabase

class SourceDataSource(private val database: NewsAppDatabase) {
    fun getAllSources(): List<SourceRaw> =
        database.newsAppDatabaseQueries.selectAllSources(::mapToSourceRaw).executeAsList()

    fun insertSources(sourcesRaw: List<SourceRaw>) {
        database.newsAppDatabaseQueries.run {
            transaction {
                sourcesRaw.forEach { sourceRaw ->
                    with(sourceRaw) {
                        insertSource(id, name, description, language, country)
                    }
                }
            }
        }
    }

    fun clearAllSources() = database.newsAppDatabaseQueries.removeAllSources()

    private fun mapToSourceRaw(
        id: String,
        name: String,
        desc: String,
        language: String,
        country: String
    ): SourceRaw = SourceRaw(
        id = id,
        name = name,
        description = desc,
        language = language,
        country = country
    )
}