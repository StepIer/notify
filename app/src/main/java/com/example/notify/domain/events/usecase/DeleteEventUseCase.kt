package com.example.notify.domain.events.usecase

import com.example.notify.domain.events.model.Event

interface DeleteEventUseCase {
    fun invoke(event: Event)
}