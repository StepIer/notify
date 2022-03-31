package com.example.notify.presentation.screens.notes

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notify.domain.notes.model.Note
import com.example.notify.presentation.screens.notes.components.NoteTile
import com.example.notify.route.NavigationRoute

@Composable
fun NotesScreen(
    navController: NavController
) {
    val notesViewModel: NotesViewModel = hiltViewModel()
    val notes: State<List<Note>> = notesViewModel.getNotes().collectAsState(initial = listOf())

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
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                //todo searchbar
            }
            items(notes.value) {
                NoteTile(note = it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotesPreview() {
    NotesScreen(navController = rememberNavController())
}
