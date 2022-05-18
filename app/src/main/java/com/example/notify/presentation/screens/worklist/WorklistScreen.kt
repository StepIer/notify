package com.example.notify.presentation.screens.worklist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notify.R
import com.example.notify.domain.worklist.model.Worklist
import com.example.notify.presentation.components.NotifyAlertDialog
import com.example.notify.presentation.components.NotifyTextField
import com.example.notify.presentation.screens.worklist.components.WorklistAddBtn
import com.example.notify.presentation.screens.worklist.components.WorklistTile
import com.example.notify.presentation.theme.Green400
import com.example.notify.presentation.theme.Orange400
import com.example.notify.presentation.theme.Red400
import com.example.notify.route.NavigationArguments
import com.example.notify.route.NavigationRoute

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ToDoListScreen(
    navController: NavController
) {
    val worklistViewModel: WorklistViewModel = hiltViewModel()
    val worklists: State<List<Worklist>> =
        worklistViewModel.getWorklists().collectAsState(initial = listOf())

    val isOpenDialog = remember { mutableStateOf(false) }
    val title = remember { mutableStateOf("") }
    val color = remember { mutableStateOf(Orange400.toArgb()) }
    var expanded by remember { mutableStateOf(false) }

    val openDialog = remember { mutableStateOf(false) }
    val selectedWorklist = remember { mutableStateOf<Worklist?>(null) }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(worklists.value) {
            WorklistTile(worklist = it,
                onClick = {
                    navController.navigate(NavigationRoute.ROUTE_ENTRY + "?${NavigationArguments.ARGUMENT_WORKLIST}=${it.title}")
                },
                onDeleteClick = {
                    selectedWorklist.value = it
                    openDialog.value = true
                })
        }
        item {
            WorklistAddBtn {
                isOpenDialog.value = true
            }
        }
    }

    NotifyAlertDialog(
        isOpenDialog = openDialog,
        title = stringResource(id = R.string.title_dialog_worklist),
        text = stringResource(id = R.string.text_dialog_worklist)
    ) {
        selectedWorklist.value?.let { worklist ->
            worklistViewModel.deleteWorklist(title = worklist.title)
        }
    }

    if (isOpenDialog.value) {
        AlertDialog(
            onDismissRequest = {
                isOpenDialog.value = false
            },
            text = {
                Column() {
                    NotifyTextField(value = title.value, onValueChange = {
                        title.value = it
                    }, placeholder = "Add title")
                    Row() {
                        Text(
                            text = "Choose color: ",
                            modifier = Modifier.align(alignment = Alignment.CenterVertically)
                        )
                        Box {
                            IconButton(onClick = {
                                expanded = true
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_outline_palette_24),
                                    contentDescription = "change color",
                                    tint = Color(color.value)
                                )
                            }
                            DropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                IconButton(onClick = {
                                    color.value = Red400.toArgb()
                                    expanded = false
                                }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_outline_invert_colors_24),
                                        contentDescription = "red color",
                                        tint = Red400
                                    )
                                }
                                IconButton(onClick = {
                                    color.value = Orange400.toArgb()
                                    expanded = false
                                }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_outline_invert_colors_24),
                                        contentDescription = "orange color",
                                        tint = Orange400
                                    )
                                }
                                IconButton(onClick = {
                                    color.value = Green400.toArgb()
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
                    }

                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        worklistViewModel.insertWorklist(
                            Worklist(
                                title = title.value,
                                color = color.value
                            )
                        )
                        isOpenDialog.value = false
                        title.value = ""
                    }) {
                    Text(stringResource(R.string.confirm_button))
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        isOpenDialog.value = false
                    }) {
                    Text(stringResource(R.string.dismiss_button))
                }
            }
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ToDoListScreenPrev() {
    ToDoListScreen(
        navController = rememberNavController()
    )
}