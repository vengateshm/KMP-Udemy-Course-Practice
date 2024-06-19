package dev.vengateshm.kotlin_multiplatform_samples.sources.data

class SourceRepository(
    private val dataSource: SourceDataSource,
    private val sourcesService: SourcesService
) {
    suspend fun getAllSources(): List<SourceRaw> {
        var localSources = dataSource.getAllSources()
        println("Loaded sources ${localSources.size} from database")
        if (localSources.isEmpty()) {
            localSources = sourcesService.getSources()
            dataSource.insertSources(localSources)
        }
        return localSources
    }
}