package com.example.notify.presentation.screens.notes.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.notify.domain.notes.model.Note

@Composable
fun NoteTile(
    note: Note
) {
    Text(text = note.text ?: "nothing")
}