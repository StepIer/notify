package com.example.notify.presentation.screens.worklist

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.notify.domain.worklist.model.Worklist
import com.example.notify.presentation.screens.worklist.components.WorklistTile

@OptIn(ExperimentalMaterialApi::class)
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
        LazyColumn {
            items(worklists.value, { worklist: Worklist -> worklist.title }) { item ->
                val dismissState = rememberDismissState()

                if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                    notesList.remove(item)
                }
                SwipeToDismiss(
                    state = dismissState,
                    modifier = Modifier
                        .padding(vertical = Dp(1f)),
                    directions = setOf(
                        DismissDirection.EndToStart
                    ),
                    dismissThresholds = { direction ->
                        FractionalThreshold(if (direction == DismissDirection.EndToStart) 0.1f else 0.05f)
                    },
                    background = {
                        val color by animateColorAsState(
                            when (dismissState.targetValue) {
                                DismissValue.Default -> Color.White
                                else -> Color.Red
                            }
                        )
                        val alignment = Alignment.CenterEnd
                        val icon = Icons.Default.Delete

                        val scale by animateFloatAsState(
                            if (dismissState.targetValue == DismissValue.Default) 0.75f else 1f
                        )

                        Box(
                            Modifier
                                .fillMaxSize()
                                .background(color)
                                .padding(horizontal = Dp(20f)),
                            contentAlignment = alignment
                        ) {
                            Icon(
                                icon,
                                contentDescription = "Delete Icon",
                                modifier = Modifier.scale(scale)
                            )
                        }
                    },
                    dismissContent = {

                        Card(
                            elevation = animateDpAsState(
                                if (dismissState.dismissDirection != null) 4.dp else 0.dp
                            ).value,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(Dp(50f))
                                .align(alignment = Alignment.CenterVertically)
                        ) {
                            setUpRow(item = item)
                        }
                    }
                )

                Divider(Modifier.fillMaxWidth(), Color.DarkGray)
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ToDoListScreenPrev() {
    ToDoListScreen(
        navController = rememberNavController()
    )
}