package com.example.notify.domain.events.usecase

import com.example.notify.domain.events.model.Event

interface InsertEventUseCase {
    fun invoke(event: Event)
}