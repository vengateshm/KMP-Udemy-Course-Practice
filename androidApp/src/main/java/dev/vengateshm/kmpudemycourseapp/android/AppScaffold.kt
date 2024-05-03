package dev.vengateshm.kmpudemycourseapp.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.vengateshm.kmpudemycourseapp.android.screens.AboutScreen
import dev.vengateshm.kmpudemycourseapp.android.screens.ArticlesScreen
import dev.vengateshm.kmpudemycourseapp.android.screens.Screens
import dev.vengateshm.kmpudemycourseapp.android.screens.SourcesScreen
import dev.vengateshm.kmpudemycourseapp.articles.presentation.ArticlesViewModel
import dev.vengateshm.kmpudemycourseapp.sources.presentation.SourcesViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun AppScaffold(articlesViewModel: ArticlesViewModel?) {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            articlesViewModel
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    articlesViewModelIgnore: ArticlesViewModel?
) {
    NavHost(
        navController = navController,
        startDestination = Screens.ARTICLES.route,
        modifier = modifier,
    ) {
        composable(Screens.ARTICLES.route) {
            val articlesViewModel: ArticlesViewModel = getViewModel()
            ArticlesScreen(
                onAboutButtonClick = { navController.navigate(Screens.ABOUT_DEVICE.route) },
                onSourceButtonClick = { navController.navigate(Screens.SOURCES_LIST.route) },
                articlesViewModel = articlesViewModel,
            )
        }
        composable(Screens.SOURCES_LIST.route) {
            val sourcesViewModel: SourcesViewModel = getViewModel()
            SourcesScreen(sourcesViewModel = sourcesViewModel)
        }
        composable(Screens.ABOUT_DEVICE.route) {
            AboutScreen(
                onUpButtonClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}