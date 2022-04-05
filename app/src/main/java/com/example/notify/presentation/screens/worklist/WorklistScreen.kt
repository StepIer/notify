package com.example.notify.presentation.screens.worklist

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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.notify.domain.worklist.model.Worklist
import com.example.notify.presentation.screens.worklist.components.WorklistTile

@Composable
fun ToDoListScreen(
    navController: NavController
) {
    val worklistViewModel: WorklistViewModel = hiltViewModel()
    val worklists: State<List<Worklist>> =
        worklistViewModel.getWorklists().collectAsState(initial = listOf())

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                content = {
                    Icon(Icons.Filled.Add, contentDescription = "Добавить")
                },
                onClick = {
                    worklistViewModel.insertWorklist(Worklist("dscsdc"))
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
            items(worklists.value) {
                //todo add click listener
                WorklistTile(it.title)
            }
        }
    }
}