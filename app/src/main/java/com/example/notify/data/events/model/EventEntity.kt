package com.example.notify.data.events.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notify.domain.events.model.Event
import java.time.LocalDateTime

@Entity(tableName = "events")
data class EventEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int?,
    @ColumnInfo(name = "title")
    var title: String?,
    @ColumnInfo(name = "message")
    var message: String?,
    @ColumnInfo(name = "date")
    val date: LocalDateTime?,
)

fun EventEntity.toDomainModel(): Event {
    return Event(
        id = this.id,
        title = this.title,
        message = this.message,
        date = this.date
    )
}

fun Event.toDataModel(): EventEntity {
    return EventEntity(
        id = this.id,
        title = this.title,
        message = this.message,
        date = this.date
    )
}