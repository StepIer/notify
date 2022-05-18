package com.example.notify.presentation.screens.events

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notify.domain.events.model.Event
import com.example.notify.presentation.components.NotifyTextField
import com.example.notify.presentation.screens.events.components.EventsAddBtn
import com.example.notify.presentation.screens.events.components.EventsTile
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import kotlin.random.Random


@Composable
fun EventsScreen() {

    val eventsViewModel: EventsViewModel = hiltViewModel()
    val events: State<List<Event>> =
        eventsViewModel.getAllEvents().collectAsState(initial = listOf())

    val isOpenDialog = remember { mutableStateOf(false) }
    val title = remember { mutableStateOf("") }
    val message = remember { mutableStateOf("") }
    val date = remember { mutableStateOf(LocalDate.now()) }
    val time = remember { mutableStateOf(LocalTime.now()) }

    val dateDialogState = rememberMaterialDialogState()
    val timeDialogState = rememberMaterialDialogState()

    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(events.value) {
            EventsTile(event = it,
                onClick = {

                },
                onDeleteClick = {
                    eventsViewModel.deleteEvent(it)
                })
        }
        item {
            EventsAddBtn {
                isOpenDialog.value = true
            }
        }
    }

    if (isOpenDialog.value) {
        AlertDialog(
            onDismissRequest = {
                isOpenDialog.value = false
            },
            text = {
                Column {

                    NotifyTextField(value = title.value, onValueChange = {
                        title.value = it
                    }, placeholder = "Add title")
                    NotifyTextField(value = message.value, onValueChange = {
                        message.value = it
                    }, placeholder = "Add message")
                    Row {
                        ClickableText(
                            text = AnnotatedString(
                                date.value.format(
                                    DateTimeFormatter.ofPattern(
                                        "dd-MM-yyyy"
                                    )
                                )
                            ), onClick = {
                                dateDialogState.show()
                            })
                        Spacer(modifier = Modifier.width(30.dp))
                        ClickableText(
                            text = AnnotatedString(
                                time.value.format(
                                    DateTimeFormatter.ofPattern(
                                        "HH:mm:ss"
                                    )
                                )
                            ), onClick = {
                                timeDialogState.show()
                            })
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        eventsViewModel.insertEvent(
                            Event(
                                title = title.value,
                                message = message.value,
                                date = LocalDateTime.of(date.value, time.value)
                            )
                        )
                        isOpenDialog.value = false
                        val random = Random(200)
                        val intent = Intent(context, MyBroadcastReceiver::class.java)
                        intent.putExtra("title", title.value)
                        intent.putExtra("message", message.value)
                        val pendingIntent = PendingIntent.getBroadcast(
                            context.applicationContext,
                            random.nextInt(),
                            intent,
                            PendingIntent.FLAG_UPDATE_CURRENT
                        )
                        val alarmManager =
                            context.getSystemService(Context.ALARM_SERVICE) as AlarmManager?
                        alarmManager!![AlarmManager.RTC_WAKEUP, LocalDateTime.of(
                            date.value,
                            time.value
                        ).atZone(ZoneId.systemDefault()).toEpochSecond() * 1000] = pendingIntent
                    }) {
                    Text(stringResource(com.example.notify.R.string.confirm_button))
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        isOpenDialog.value = false
                    }) {
                    Text(stringResource(com.example.notify.R.string.dismiss_button))
                }
            }
        )
    }

    MaterialDialog(
        dialogState = dateDialogState,
        buttons = {
            positiveButton("Ok")
            negativeButton("Cancel")
        }
    ) {
        datepicker {
            date.value = it
            // Do stuff with java.time.LocalDate object which is passed in
        }
    }

/* This should be called in an onClick or an Effect */

    MaterialDialog(
        dialogState = timeDialogState,
        buttons = {
            positiveButton("Ok")
            negativeButton("Cancel")
        }
    ) {
        timepicker {
            time.value = it
            // Do stuff with java.time.LocalTime object which is passed in
        }
    }
}

