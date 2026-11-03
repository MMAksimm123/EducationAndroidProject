package com.example.educationandroidproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.educationandroidproject.presentation.appdetails.AppDetailScreen
import com.example.educationandroidproject.presentation.appdetails.ListAppScreen
import kotlinx.serialization.Serializable

@Serializable
data object ListDestination

@Serializable
data class DetailDestination(val  appId: String)
@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ListDestination
    ) {
        composable<ListDestination> {
            ListAppScreen(
                onAppClick = { app ->
                    navController.navigate(DetailDestination(app.id))
                }
            )
        }

        composable<DetailDestination> {
            AppDetailScreen(
                onShowcaseAppClick = { showcaseApp ->
                    navController.navigate(DetailDestination(showcaseApp.id)) {
                        popUpTo<ListDestination> {inclusive = false}
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}