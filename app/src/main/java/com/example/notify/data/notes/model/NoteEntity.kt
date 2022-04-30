package com.example.notify.data.notes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notify.domain.notes.model.Note
import java.time.LocalDateTime

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "text")
    val text: String?,
    @ColumnInfo(name = "photo")
    val photo: String?,
    @ColumnInfo(name = "paint")
    val paint: PaintData,
    @ColumnInfo(name = "audio")
    val audio: String?,
    @ColumnInfo(name = "color")
    val color: Int,
    @ColumnInfo(name = "date")
    val date: LocalDateTime,
)

fun NoteEntity.toDomainModel(): Note {
    return Note(
        id = this.id,
        title = this.title,
        text = this.text,
        photo = this.photo,
        paint = this.paint.toDomainModel(),
        audio = this.audio,
        color = this.color,
        date = this.date
    )
}

fun Note.toDataModel(): NoteEntity {
    return NoteEntity(
        id = this.id,
        title = this.title,
        text = this.text,
        photo = this.photo,
        paint = this.paint.toDataModel(),
        audio = this.audio,
        color = this.color,
        date = this.date
    )
}