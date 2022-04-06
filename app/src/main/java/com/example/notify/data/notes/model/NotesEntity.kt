package com.example.notify.data.notes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notify.domain.notes.model.Note
import java.time.LocalDateTime

@Entity(tableName = "notes")
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "text")
    val text: String?,
    @ColumnInfo(name = "image")
    val image: String?,
    @ColumnInfo(name = "audio")
    val audio: String?,
    @ColumnInfo(name = "color")
    val color: Int,
    @ColumnInfo(name = "date")
    val date: LocalDateTime,
)

fun NotesEntity.toDomainModel(): Note {
    return Note(
        id = this.id,
        title = this.title,
        text = this.text,
        image = this.image,
        audio = this.audio,
        color = this.color,
        date = this.date
    )
}