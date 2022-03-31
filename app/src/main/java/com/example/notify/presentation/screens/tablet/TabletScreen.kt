package com.example.notify.presentation.screens.tablet

import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.notify.R
import com.example.notify.domain.notes.model.Note

@Composable
fun TabletScreen(navController: NavController) {

    val tabletViewModel: TabletViewModel = hiltViewModel()
    val text = remember { mutableStateOf("Text") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(text = "Top App Bar")
                        IconButton(onClick = {
                            tabletViewModel.saveNote(
                                Note(
                                    text = text.value,
                                    date = 1
                                )
                            )
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
        },
        bottomBar = {
            BottomAppBar {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_outline_text_format_24),
                        contentDescription = "text format"
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_outline_brush_24),
                        contentDescription = "brush format"
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_outline_monochrome_photos_24),
                        contentDescription = "photo format"
                    )
                }
            }
        }
    ) {
        TextField(value = text.value, onValueChange = {
            text.value = it
        })
    }
}