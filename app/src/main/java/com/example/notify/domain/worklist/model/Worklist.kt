package com.example.notify.domain.worklist.model

import com.example.notify.data.worklist.model.WorklistEntity

data class Worklist(
    val title: String,
    val color: String? = null,
)

fun Worklist.toData(): WorklistEntity {
    return WorklistEntity(
        title = this.title,
        color = this.color
    )
}