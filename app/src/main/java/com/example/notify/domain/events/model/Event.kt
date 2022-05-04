package com.example.notify.domain.events.model

import java.time.LocalDateTime

data class Event(
    var id: Int? = null,
    var title: String? = null,
    var message: String? = null,
    val date: LocalDateTime? = null,
)