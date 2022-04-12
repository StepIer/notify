package com.example.notify.presentation.screens.tablet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notify.domain.notes.model.Note
import com.example.notify.domain.notes.usecase.GetNoteByIdUseCase
import com.example.notify.domain.notes.usecase.InsertNoteUseCase
import com.example.notify.domain.notes.usecase.UpdateNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TabletViewModel @Inject constructor(
    private val insertNoteUseCase: InsertNoteUseCase,
    private val getNoteByIdUseCase: GetNoteByIdUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase
) : ViewModel() {

    fun saveNote(note: Note, isNeedUpdate: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            if (isNeedUpdate) {
                updateNoteUseCase.invoke(note)
            } else {
                insertNoteUseCase.invoke(note)
            }

        }
    }

    fun getNoteById(id: Int): Flow<Note> {
        return getNoteByIdUseCase.invoke(id)
    }
}