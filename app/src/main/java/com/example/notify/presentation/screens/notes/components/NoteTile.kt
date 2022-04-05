package com.example.notify.presentation.screens.notes.components

import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.notify.domain.notes.model.Note

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NoteTile(
    note: Note,
    onClick: () -> Unit,
) {
    Card(onClick = { onClick() }) {
        Text(text = note.text ?: "nothing")
    }
}