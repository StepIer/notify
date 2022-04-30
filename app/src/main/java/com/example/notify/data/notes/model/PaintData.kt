package com.example.notify.data.notes.model

import com.example.notify.domain.notes.model.Paint
import kotlinx.serialization.Serializable

@Serializable
data class PaintData(
    val item: MutableList<Pair<Boolean, Pair<Float, Float>>>
)

fun PaintData.toDomainModel(): Paint {
    return Paint(
        item = this.item
    )
}

fun Paint.toDataModel(): PaintData {
    return PaintData(
        item = this.item
    )
}