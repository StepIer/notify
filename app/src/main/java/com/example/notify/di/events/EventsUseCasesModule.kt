package com.example.notify.di.events

import com.example.notify.domain.events.adapter.EventsRepository
import com.example.notify.domain.events.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object EventsUseCasesModule {

    @Provides
    fun provideGetAllEventsUseCase(
        eventsRepository: EventsRepository,
    ): GetAllEventsUseCase {
        return GetAllEventsUseCaseImpl(eventsRepository)
    }

    @Provides
    fun provideInsertEventUseCase(
        eventsRepository: EventsRepository,
    ): InsertEventUseCase {
        return InsertEventUseCaseImpl(eventsRepository)
    }

    @Provides
    fun provideDeleteEventUseCase(
        eventsRepository: EventsRepository,
    ): DeleteEventUseCase {
        return DeleteEventUseCaseImpl(eventsRepository)
    }
}