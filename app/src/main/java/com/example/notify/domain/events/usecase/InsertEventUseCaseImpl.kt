package com.example.notify.domain.events.usecase

import com.example.notify.domain.events.adapter.EventsRepository
import com.example.notify.domain.events.model.Event

class InsertEventUseCaseImpl(
    private val eventsRepository: EventsRepository
) : InsertEventUseCase {
    override fun invoke(event: Event) {
        eventsRepository.insertEvent(event)
    }
}