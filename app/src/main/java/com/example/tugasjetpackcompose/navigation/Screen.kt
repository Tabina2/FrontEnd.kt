package com.example.tugasjetpackcompose.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Search : Screen("search")
    object Profile : Screen("profile")
    object Detail : Screen("detail/{name}/{image}/{description}") {
        fun createRoute(name: String, image: Int, description: String) =
            "detail/$name/$image/$description"
    }
}