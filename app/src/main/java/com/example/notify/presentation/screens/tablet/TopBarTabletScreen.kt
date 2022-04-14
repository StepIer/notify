package com.example.notify.presentation.screens.tablet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.notify.R
import com.example.notify.domain.notes.model.Note
import com.example.notify.presentation.components.NotifyTextField
import com.example.notify.presentation.theme.Green400
import com.example.notify.presentation.theme.Orange400
import com.example.notify.presentation.theme.Red400
import java.time.LocalDateTime

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
                    placeholder = stringResource(id = R.string.title_note),
                    textColor = Color.White
                )

                var expanded by remember { mutableStateOf(false) }

                Box {
                    IconButton(onClick = {
                        expanded = true
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_outline_palette_24),
                            contentDescription = "change color",
                            tint = Color(note.value.color)
                        )
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        IconButton(onClick = {
                            note.value = note.value.copy(
                                color = Red400.toArgb()
                            )
                            expanded = false
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_outline_invert_colors_24),
                                contentDescription = "red color",
                                tint = Red400
                            )
                        }
                        IconButton(onClick = {
                            note.value = note.value.copy(
                                color = Orange400.toArgb()
                            )
                            expanded = false
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_outline_invert_colors_24),
                                contentDescription = "orange color",
                                tint = Orange400
                            )
                        }
                        IconButton(onClick = {
                            note.value = note.value.copy(
                                color = Green400.toArgb()
                            )
                            expanded = false
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_outline_invert_colors_24),
                                contentDescription = "green color",
                                tint = Green400
                            )
                        }
                    }
                }
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