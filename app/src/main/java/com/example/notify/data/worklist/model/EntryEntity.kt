package com.example.notify.data.worklist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notify.domain.worklist.model.Entry

@Entity(
    tableName = "entry"
)
data class EntryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int?,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "isCompleted")
    val isCompleted: Boolean,
    @ColumnInfo(name = "worklist")
    val worklist: String,
)

fun EntryEntity.toDomain(): Entry {
    return Entry(
        id = this.id,
        title = this.title,
        isCompleted = this.isCompleted,
        worklist = this.worklist
    )
}