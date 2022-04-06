package com.example.notify.domain.notes.model

import com.example.notify.data.notes.model.NotesEntity
import java.time.LocalDateTime

data class Note(
    val id: Int? = null,
    val title: String? = null,
    val text: String? = null,
    val image: String? = null,
    val audio: String? = null,
    val color: Int,
    val date: LocalDateTime,
)

fun Note.toDataModel(): NotesEntity {
    return NotesEntity(
        id = this.id,
        title = this.title,
        text = this.text,
        image = this.image,
        audio = this.audio,
        color = this.color,
        date = this.date
    )
}