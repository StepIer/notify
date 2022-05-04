package com.example.notify.domain.events.adapter

import com.example.notify.domain.events.model.Event
import kotlinx.coroutines.flow.Flow

interface EventsRepository {
    fun getAllEvents(): Flow<List<Event>>
    fun insertEvent(event: Event)
    fun deleteEventById(id: Int)
    fun updateEvent(event: Event)
}