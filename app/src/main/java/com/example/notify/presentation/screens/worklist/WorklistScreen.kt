package com.example.notify.presentation.screens.worklist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.notify.route.NavigationRoute

@Composable
fun ToDoListScreen(
    navController: NavController
) {
    val worklistViewModel: WorklistViewModel = hiltViewModel()
//    val notes: State<List<Note>> = notesViewModel.getNotes().collectAsState(initial = listOf())

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
//            items(notes.value) {
//                NoteTile(note = it)
//            }
        }
    }
}