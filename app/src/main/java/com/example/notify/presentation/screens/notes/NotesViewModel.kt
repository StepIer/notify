package com.example.notify.presentation.screens.notes

import androidx.lifecycle.ViewModel
import com.example.notify.domain.notes.model.Note
import com.example.notify.domain.notes.usecase.GetAllNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase
) : ViewModel() {

    fun getNotes(): Flow<List<Note>> {
        return getAllNotesUseCase.invoke()
    }
}