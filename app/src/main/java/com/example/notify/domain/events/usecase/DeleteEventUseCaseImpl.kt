package com.example.notify.domain.events.usecase

import com.example.notify.domain.events.adapter.EventsRepository
import com.example.notify.domain.events.model.Event

class DeleteEventUseCaseImpl(
    private val eventsRepository: EventsRepository
) : DeleteEventUseCase {
    override fun invoke(event: Event) {
        eventsRepository.deleteEventById(event.id!!)
    }
}