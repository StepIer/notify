package com.example.notify.presentation.screens.tablet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.notify.R
import com.example.notify.domain.notes.model.Note
import com.example.notify.presentation.components.NotifyTextField
import java.time.LocalDateTime

@Composable
fun TabletScreen(
    navController: NavController,
    noteId: Int?,
) {

    val tabletViewModel: TabletViewModel = hiltViewModel()
    val note = (noteId?.let {
        tabletViewModel.getNoteById(it).collectAsState(initial = Note())
    } as? MutableState<Note>) ?: remember {
        mutableStateOf(Note())
    }

//    val note = remember {
//        mutableStateOf(Note())
//    }

    Scaffold(
        topBar = {
            TopBarTabletScreen(
                note = note,
                noteId = noteId,
                tabletViewModel = tabletViewModel,
                navController = navController
            )
        },
        bottomBar = {
            BottomBarTabletScreen()
        }
    ) {
        Box(modifier = Modifier.padding(16.dp)) {
            NotifyTextField(
                placeholder = "ewfwefdswfdsfwf",
                value = note.value.text ?: "",
                onValueChange = {
                    note.value = note.value.copy(
                        text = it
                    )
                },
                textSize = 24.sp,
                isNeedFocusPadding = true
            )
        }
    }
}

@Composable
fun TopBarTabletScreen(
    note: MutableState<Note>,
    noteId: Int?,
    tabletViewModel: TabletViewModel,
    navController: NavController
) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                NotifyTextField(
                    modifier = Modifier.weight(3f),
                    value = note.value.title ?: "",
                    onValueChange = {
                        note.value = note.value.copy(
                            title = it
                        )
                    },
                    placeholder = "Title note",
                    textColor = Color.White
                )
                IconButton(onClick = {
                    tabletViewModel.saveNote(
                        note.value.copy(
                            date = LocalDateTime.now()
                        ),
                        isNeedUpdate = noteId != null,
                    )
                    navController.popBackStack()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_outline_save_24),
                        contentDescription = "save note"
                    )
                }
            }
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Filled.ArrowBack, "backIcon")
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 10.dp
    )
}

@Composable
fun BottomBarTabletScreen() {
    BottomAppBar {
        IconButton(
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_text_format_24),
                contentDescription = "text format"
            )
        }
        IconButton(
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_brush_24),
                contentDescription = "brush format"
            )
        }
        IconButton(
            modifier = Modifier.weight(1f),
            onClick = { /*TODO*/ }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_monochrome_photos_24),
                contentDescription = "photo format"
            )
        }
    }
}


