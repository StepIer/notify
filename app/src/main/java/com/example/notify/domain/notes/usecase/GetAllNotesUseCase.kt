package com.example.notify.domain.notes.usecase

import com.example.notify.domain.notes.model.Note

interface GetAllNotesUseCase {
    suspend fun invoke(): List<Note>
}
