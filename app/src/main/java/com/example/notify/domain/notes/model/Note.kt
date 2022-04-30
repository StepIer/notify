package com.example.notify.domain.notes.model

import androidx.compose.ui.graphics.toArgb
import com.example.notify.presentation.theme.Orange400
import java.time.LocalDateTime

data class Note(
    val id: Int? = null,
    val title: String? = null,
    val text: String? = null,
    val photo: String? = null,
    val paint: Paint = Paint(item = mutableListOf()),
    val audio: String? = null,
    val color: Int = Orange400.toArgb(),
    val date: LocalDateTime = LocalDateTime.now(),
)
