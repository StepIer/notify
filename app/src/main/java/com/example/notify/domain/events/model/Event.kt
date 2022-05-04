package com.example.notify.domain.events.model

import java.time.LocalDateTime

data class Event(
    var id: Int?,
    var title: String?,
    var message: String?,
    val date: LocalDateTime?,
)