package com.example.notify.presentation.screens.tablet

import androidx.lifecycle.ViewModel
import com.example.notify.domain.notes.model.Note
import com.example.notify.domain.notes.usecase.InsertNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TabletViewModel @Inject constructor(
    private val insertNoteUseCase: InsertNoteUseCase
) : ViewModel() {

    fun saveNote(note: Note) {
        insertNoteUseCase.invoke(note)
    }
}