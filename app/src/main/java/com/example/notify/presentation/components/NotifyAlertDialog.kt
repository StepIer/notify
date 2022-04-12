package com.example.notify.presentation.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.stringResource
import com.example.notify.R

@Composable
fun NotifyAlertDialog(
    isOpenDialog: MutableState<Boolean>,
    title: String,
    text: String,
    confirmClick: () -> Unit
) {
    if (isOpenDialog.value) {
        AlertDialog(
            onDismissRequest = {
                isOpenDialog.value = false
            },
            title = {
                Text(text = title)
            },
            text = {
                Text(text)
            },
            confirmButton = {
                Button(
                    onClick = {
                        confirmClick()
                        isOpenDialog.value = false
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

