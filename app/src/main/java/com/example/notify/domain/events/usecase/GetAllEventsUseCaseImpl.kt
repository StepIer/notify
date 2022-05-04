package com.example.notify.domain.events.usecase

import com.example.notify.domain.events.adapter.EventsRepository
import com.example.notify.domain.events.model.Event
import kotlinx.coroutines.flow.Flow

class GetAllEventsUseCaseImpl(
    private val eventsRepository: EventsRepository
) : GetAllEventsUseCase {
    override fun invoke(): Flow<List<Event>> {
        return eventsRepository.getAllEvents()
    }
}