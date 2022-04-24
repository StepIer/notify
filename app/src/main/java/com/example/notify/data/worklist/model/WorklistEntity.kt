package com.example.notify.data.worklist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notify.domain.worklist.model.Worklist

@Entity(tableName = "worklist")
data class WorklistEntity(
    @PrimaryKey
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "color")
    val color: Int,
)

fun WorklistEntity.toDomain(): Worklist {
    return Worklist(
        title = this.title,
        color = this.color
    )
}