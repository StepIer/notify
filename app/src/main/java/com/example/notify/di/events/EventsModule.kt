package com.example.notify.di.events

import com.example.notify.data.events.adapter.EventsRepositoryImpl
import com.example.notify.data.events.db.EventsDao
import com.example.notify.domain.events.adapter.EventsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object EventsModule {

    @Provides
    fun provideEventsRepository(
        eventsDao: EventsDao
    ): EventsRepository {
        return EventsRepositoryImpl(
            eventsDao
        )
    }
}
