package com.example.notify.presentation.screens.notes

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notify.presentation.screens.notes.components.NoteTile
import com.example.notify.route.NavigationRoute

@Composable
fun NotesScreen(
    navController: NavController
) {
    val notesViewModel: NotesViewModel = hiltViewModel()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                content = {
                    Icon(Icons.Filled.Add, contentDescription = "Добавить")
                },
                onClick = {
                    navController.navigate(NavigationRoute.ROUTE_TABLET)
                }
            )
        },
        isFloatingActionButtonDocked = true,
    ) {
        NoteTile()
    }
}

@Preview(showBackground = true)
@Composable
fun NotesPreview() {
    NotesScreen(navController = rememberNavController())
}
