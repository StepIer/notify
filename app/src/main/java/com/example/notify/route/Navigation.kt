package com.example.notify.route

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notify.presentation.screens.main.MainScreen
import com.example.notify.presentation.screens.tablet.TabletScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationRoute.ROUTE_MAIN) {
        composable(NavigationRoute.ROUTE_MAIN) {
            MainScreen(navController = navController)
        }
        composable(NavigationRoute.ROUTE_TABLET) {
            TabletScreen(navController = navController)
        }
    }
}