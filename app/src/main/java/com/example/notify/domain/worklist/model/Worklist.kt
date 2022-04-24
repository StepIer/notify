package com.example.notify.domain.worklist.model

import androidx.compose.ui.graphics.toArgb
import com.example.notify.data.worklist.model.WorklistEntity
import com.example.notify.presentation.theme.Orange400

data class Worklist(
    val title: String,
    val color: Int = Orange400.toArgb(),
)

fun Worklist.toData(): WorklistEntity {
    return WorklistEntity(
        title = this.title,
        color = this.color
    )
}