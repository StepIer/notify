package com.example.notify.presentation.screens.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notify.domain.notes.model.Note
import com.example.notify.domain.notes.usecase.DeleteNoteByIdUseCase
import com.example.notify.domain.notes.usecase.GetAllNotesUseCase
import com.example.notify.domain.notes.usecase.InsertNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNoteByIdUseCase: DeleteNoteByIdUseCase,
    private val insertNoteUseCase: InsertNoteUseCase,
) : ViewModel() {

    fun getNotes(): Flow<List<Note>> {
        return getAllNotesUseCase.invoke()
    }

    fun deleteNoteById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteNoteByIdUseCase.invoke(id)
        }
    }

    fun insertNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            insertNoteUseCase.invoke(note)
        }
    }
}