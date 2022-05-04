package com.example.notify.domain.events.usecase

import com.example.notify.domain.events.model.Event
import kotlinx.coroutines.flow.Flow

interface GetAllEventsUseCase {
    fun invoke(): Flow<List<Event>>
}