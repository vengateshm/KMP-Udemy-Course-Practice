package dev.vengateshm.kmpudemycourseapp.articles.data

class ArticleRepository(
    private val dataSource: ArticlesDataSource,
    private val articlesService: ArticlesService
) {
    suspend fun getArticles(forceFetch: Boolean): List<ArticleRaw> {
        if (forceFetch) dataSource.deleteArticles()
        var localArticles = dataSource.getAllArticles()
        println("Loaded ${localArticles.size} from database")
        println("Is force fetch $forceFetch")
        if (localArticles.isEmpty()) {
            localArticles = articlesService.getArticles()
            dataSource.insertArticles(localArticles)
        }
        return localArticles
    }
}