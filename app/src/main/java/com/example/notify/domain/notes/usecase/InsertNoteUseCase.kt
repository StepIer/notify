package com.example.notify.domain.notes.usecase

import com.example.notify.domain.notes.model.Note

interface InsertNoteUseCase {
    suspend fun invoke(note: Note)
}