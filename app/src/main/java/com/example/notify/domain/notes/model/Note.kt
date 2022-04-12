package com.example.notify.domain.notes.model

import androidx.compose.ui.graphics.toArgb
import com.example.notify.data.notes.model.NoteEntity
import com.example.notify.presentation.theme.Orange400
import java.time.LocalDateTime

data class Note(
    val id: Int? = null,
    val title: String? = null,
    val text: String? = null,
    val image: String? = null,
    val audio: String? = null,
    val color: Int = Orange400.toArgb(),
    val date: LocalDateTime = LocalDateTime.now(),
)

fun Note.toDataModel(): NoteEntity {
    return NoteEntity(
        id = this.id,
        title = this.title,
        text = this.text,
        image = this.image,
        audio = this.audio,
        color = this.color,
        date = this.date
    )
}