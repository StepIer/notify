package com.example.notify.presentation.screens.notes

import androidx.lifecycle.ViewModel
import com.example.notify.domain.notes.usecase.GetAllNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    getAllNotesUseCase: GetAllNotesUseCase
) : ViewModel() {
}