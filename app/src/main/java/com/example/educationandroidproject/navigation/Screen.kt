package com.example.educationandroidproject.navigation

sealed class Screen(val route: String) {
    object List : Screen("list")
    object Detail : Screen("detail/{appIndex}") {
        fun createRoute(index: Int) = "detail/$index"
    }
}