package com.example.notify.domain.notes.usecase

import com.example.notify.domain.notes.model.Note
import kotlinx.coroutines.flow.Flow

interface GetNoteByIdUseCase {
    fun invoke(id: Int): Flow<Note>
}