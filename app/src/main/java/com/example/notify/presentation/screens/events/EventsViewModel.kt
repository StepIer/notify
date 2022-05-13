package com.example.notify.presentation.screens.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notify.domain.events.model.Event
import com.example.notify.domain.events.usecase.DeleteEventUseCase
import com.example.notify.domain.events.usecase.GetAllEventsUseCase
import com.example.notify.domain.events.usecase.InsertEventUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val getAllEventsUseCase: GetAllEventsUseCase,
    private val insertEventUseCase: InsertEventUseCase,
    private val deleteEventUseCase: DeleteEventUseCase
) : ViewModel() {

    fun getAllEvents(): Flow<List<Event>> {
        return getAllEventsUseCase.invoke()
    }

    fun insertEvent(event: Event) {
        viewModelScope.launch(Dispatchers.IO) {
            insertEventUseCase.invoke(event)
        }
    }

    fun deleteEvent(event: Event) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteEventUseCase.invoke(event)
        }
    }
}