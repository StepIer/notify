package com.example.notify.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.notify.presentation.screens.camera.CameraScreen
import com.example.notify.presentation.screens.main.MainScreen
import com.example.notify.presentation.screens.tablet.TabletScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationRoute.ROUTE_MAIN) {

        composable(NavigationRoute.ROUTE_MAIN) {
            MainScreen(navController = navController)
        }

        composable(
            NavigationRoute.ROUTE_TABLET + "?${NavigationArguments.ARGUMENT_NOTE_ID}" +
                    "={${NavigationArguments.ARGUMENT_NOTE_ID}}" +
                    ",?${NavigationArguments.ARGUMENT_PHOTO_URI}" +
                    "={${NavigationArguments.ARGUMENT_PHOTO_URI}}",
            arguments = listOf(
                navArgument(NavigationArguments.ARGUMENT_NOTE_ID) {
                    nullable = true
                    defaultValue = null
                    type = NavType.StringType
                },
                navArgument(NavigationArguments.ARGUMENT_PHOTO_URI) {
                    nullable = true
                    defaultValue = null
                    type = NavType.StringType
                },
            )
        ) {
            TabletScreen(
                navController = navController,
                noteId = it.arguments?.getString(NavigationArguments.ARGUMENT_NOTE_ID)
                    ?.toIntOrNull(),
                photoUri = it.arguments?.getString(NavigationArguments.ARGUMENT_PHOTO_URI)
            )
        }

        composable(NavigationRoute.ROUTE_CAMERA) {
            CameraScreen(navController = navController)
        }
    }
}