package dev.vengateshm.kotlin_multiplatform_samples.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import dev.vengateshm.kotlin_multiplatform_samples.android.custom_composables.ErrorMessage
import dev.vengateshm.kotlin_multiplatform_samples.android.custom_composables.MainAppBar
import dev.vengateshm.kotlin_multiplatform_samples.articles.domain.Article
import dev.vengateshm.kotlin_multiplatform_samples.articles.presentation.ArticlesViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticlesScreen(
    onAboutButtonClick: () -> Unit,
    onSourceButtonClick: () -> Unit,
    articlesViewModel: ArticlesViewModel
) {

    val articlesState by articlesViewModel.articlesState.collectAsState()

    val scope = rememberCoroutineScope()

    Column {
        MainAppBar(
            onAboutButtonClick = onAboutButtonClick,
            onSourceButtonClick = onSourceButtonClick,
            onCheck = {
                scope.launch {
                    articlesViewModel.appDatastore().setIsDarkTheme(it)
                }
            }
        )

        if (articlesState.loading)
        //Loader()
            if (articlesState.error != null)
                ErrorMessage(articlesState.error!!)
        if (articlesState.articles.isNotEmpty())
            ArticlesListView(
                articles = articlesState.articles,
                isRefreshing = {
                    articlesState.loading
                },
                onRefresh = {
                    articlesViewModel.getArticles(forceFetch = true)
                })
    }
}

@Composable
fun ArticlesListView(
    articles: List<Article>,
    isRefreshing: () -> Boolean,
    onRefresh: () -> Unit
) {

    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isRefreshing())

    SwipeRefresh(state = swipeRefreshState, onRefresh = {
        onRefresh()
    }) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(articles) { article ->
                ArticleItemView(article = article)
            }
        }
    }
}

@Composable
fun ArticleItemView(article: Article) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = article.imageUrl,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.title,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = article.desc)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.date,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}