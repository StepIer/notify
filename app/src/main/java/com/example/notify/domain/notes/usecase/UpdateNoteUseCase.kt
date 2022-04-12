package com.example.notify.domain.notes.usecase

import com.example.notify.domain.notes.model.Note

interface UpdateNoteUseCase {

    fun invoke(note: Note)
}