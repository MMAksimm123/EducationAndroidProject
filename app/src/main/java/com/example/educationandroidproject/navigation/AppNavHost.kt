package com.example.educationandroidproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.educationandroidproject.data.SampleApps
import com.example.educationandroidproject.ui.uppdetails.AppDetailScreen
import com.example.educationandroidproject.ui.uppdetails.ListAppScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.List.route
    ) {
        composable(Screen.List.route) {
            ListAppScreen(
                onAppClick = { app ->
                    val index = SampleApps.apps.indexOf(app)
                    if (index >= 0) {
                        navController.navigate(Screen.Detail.createRoute(index))
                    }
                }
            )
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("appIndex") { type = NavType.IntType })
        ) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt("appIndex") ?: 0
            val app = SampleApps.apps[index]

            AppDetailScreen(
                appData = app,
                onShowcaseAppClick = { showcaseApp ->
                    val newIndex = SampleApps.apps.indexOf(showcaseApp)
                    if (newIndex >= 0 && newIndex != index) {
                        navController.navigate(Screen.Detail.createRoute(newIndex))
                    }
                }
            )
        }
    }
}