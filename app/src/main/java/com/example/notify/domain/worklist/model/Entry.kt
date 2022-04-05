package com.example.notify.domain.worklist.model

data class Entry(
    val id: Int,
    val title: String,
    val isCompleted: Boolean,
    val worklist: String,
    val date: String,
    val time: String,
)
