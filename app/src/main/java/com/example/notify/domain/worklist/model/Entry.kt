package com.example.notify.domain.worklist.model

import com.example.notify.data.worklist.model.EntryEntity

data class Entry(
    val id: Int? = null,
    val title: String,
    val isCompleted: Boolean,
    val worklist: String,
)

fun Entry.toData(): EntryEntity {
    return EntryEntity(
        id = this.id,
        title = this.title,
        isCompleted = this.isCompleted,
        worklist = this.worklist
    )
}