package com.example.notify.domain.notes.model

data class Notes(
    val id: Int,
    val title: String,
    val text: String,
    val image: String,
    val audio: String,
    val color: String,
)
