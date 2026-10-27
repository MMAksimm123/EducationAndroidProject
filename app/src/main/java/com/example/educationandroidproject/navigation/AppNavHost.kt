package com.example.educationandroidproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.educationandroidproject.data.SampleApps
import com.example.educationandroidproject.data.repository.AppRepositoryImpl
import com.example.educationandroidproject.presentation.appdetails.AppDetailScreen
import com.example.educationandroidproject.presentation.appdetails.ListAppScreen
import kotlinx.serialization.Serializable

@Serializable
data object ListDestination

@Serializable
data class DetailDestination(val  appId: Int)
@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val repository = AppRepositoryImpl()

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

        composable<DetailDestination> { backStackEntry ->
            val destination = backStackEntry.toRoute<DetailDestination>()
            val app = repository.getAppById(destination.appId)

            if (app != null) {
                AppDetailScreen(
                    appData = app,
                    onShowcaseAppClick = { showcaseApp ->
                        if (showcaseApp.id != destination.appId) {
                            navController.navigate(DetailDestination(showcaseApp.id)) {
                                popUpTo<ListDestination> {inclusive = false}
                                launchSingleTop = true
                            }
                        }
                    }
                )
            }
        }
    }
}