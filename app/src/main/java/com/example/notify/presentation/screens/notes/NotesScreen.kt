package com.example.notify.presentation.screens.notes

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notify.R
import com.example.notify.domain.notes.model.Note
import com.example.notify.presentation.components.NotifyAlertDialog
import com.example.notify.presentation.screens.notes.components.NoteTile
import com.example.notify.route.NavigationArguments
import com.example.notify.route.NavigationRoute

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotesScreen(
    navController: NavController
) {
    val notesViewModel: NotesViewModel = hiltViewModel()
    val notes: State<List<Note>> = notesViewModel.getNotes().collectAsState(initial = listOf())
    val openDialog = remember { mutableStateOf(false) }
    val selectedNote = remember { mutableStateOf<Note?>(null) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                content = {
                    Icon(Icons.Filled.Add, contentDescription = "Добавить")
                },
                onClick = {
                    notesViewModel.insertNote(Note())
                }
            )
        },
        isFloatingActionButtonDocked = true,
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp)
        ) {
//            item {
//                //todo searchbar
//            }
            items(notes.value) {
                NoteTile(
                    note = it,
                    onClick = {
                        navController.navigate(
                            NavigationRoute.ROUTE_TABLET +
                                    "?${NavigationArguments.ARGUMENT_NOTE_ID}=${it.id}" +
                                    ",?${NavigationArguments.ARGUMENT_PHOTO_URI}=${null}"
                        )
                    },
                    onDeleteClick = {
                        selectedNote.value = it
                        openDialog.value = true
                    }
                )
            }
        }
    }

    NotifyAlertDialog(
        isOpenDialog = openDialog,
        title = stringResource(id = R.string.title_dialog),
        text = stringResource(id = R.string.text_dialog)
    ) {
        selectedNote.value?.let {
            it.id?.let { id -> notesViewModel.deleteNoteById(id) }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun NotesPreview() {
    NotesScreen(navController = rememberNavController())
}
