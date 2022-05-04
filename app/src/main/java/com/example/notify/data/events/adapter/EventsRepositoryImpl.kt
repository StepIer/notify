package com.example.notify.data.events.adapter

import com.example.notify.data.events.db.EventsDao
import com.example.notify.data.events.model.toDataModel
import com.example.notify.data.events.model.toDomainModel
import com.example.notify.domain.events.adapter.EventsRepository
import com.example.notify.domain.events.model.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EventsRepositoryImpl(
    private val eventsDao: EventsDao
) : EventsRepository {
    override fun getAllEvents(): Flow<List<Event>> {
        return eventsDao.getAllEvents().map { list ->
            list.map {
                it.toDomainModel()
            }
        }
    }

    override fun insertEvent(event: Event) {
        eventsDao.insertEvent(event.toDataModel())
    }

    override fun deleteEventById(id: Int) {
        eventsDao.deleteEventById(id)
    }

    override fun updateEvent(event: Event) {
        eventsDao.updateEvent(event.toDataModel())
    }
}