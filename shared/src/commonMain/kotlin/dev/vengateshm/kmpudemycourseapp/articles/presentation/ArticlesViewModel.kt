package dev.vengateshm.kmpudemycourseapp.articles.presentation

import dev.vengateshm.kmpudemycourseapp.BaseViewModel
import dev.vengateshm.kmpudemycourseapp.articles.domain.Article
import dev.vengateshm.kmpudemycourseapp.articles.domain.ArticlesUseCase
import dev.vengateshm.kmpudemycourseapp.datastore.AppDatastore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val articlesUseCase: ArticlesUseCase,
    private val appDatastore: AppDatastore
) : BaseViewModel() {
    private val _articlesState = MutableStateFlow(ArticlesState(loading = true))
    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    fun getArticles(forceFetch: Boolean = false) {
        scope.launch {
//            delay(2000)
//            _articlesState.emit(ArticlesState(error = "Something went wrong"))
//            delay(2000)
//            val fetchedArticles = fetchArticles()
            _articlesState.emit(
                ArticlesState(
                    loading = true,
                    articles = articlesState.value.articles
                )
            )
            val fetchedArticles = articlesUseCase.getArticles(forceFetch)
            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }

    private suspend fun fetchArticles(): List<Article> = mockArticles

    private val mockArticles = listOf(
        Article(
            title = "Stock market today: Live updates - CNBC",
            desc = "Futures were higher in premarket trading as Wall Street tried to regain its footing.",
            date = "2023-11-09",
            imageUrl = "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080"
        ),
        Article(
            title = "Best iPhone Deals (2023): Carrier Deals, Unlocked iPhones",
            desc = "Apple's smartphones rarely go on sale, but if you’re looking to upgrade (or you're gift shopping), here are a few cost-saving options.",
            date = "2023-11-09",
            imageUrl = "https://media.wired.com/photos/622aa5c8cca6acf55fb70b57/191:100/w_1280,c_limit/iPhone-13-Pro-Colors-SOURCE-Apple-Gear.jpg",
        ),
        Article(
            title = "Samsung details ‘Galaxy AI’ and a feature that can translate phone calls in real time",
            desc = "In a new blog post, Samsung previewed what it calls “a new era of Galaxy AI” coming to its smartphones and detailed a feature that will use artificial intelligence to translate phone calls in real time.",
            date = "2023-11-09",
            imageUrl = "https://cdn.vox-cdn.com/thumbor/Ocz_QcxUdtaexp1pPTMygaqzbR8=/0x0:2000x1333/1200x628/filters:focal(1000x667:1001x668)/cdn.vox-cdn.com/uploads/chorus_asset/file/24396795/DSC04128_processed.jpg",
        ),
    )

    fun appDatastore() = appDatastore

    fun setIsDarkTheme(value: Boolean) {
        scope.launch { appDatastore().setIsDarkTheme(value) }
    }
}