package com.example.notify.domain.notes.usecase

import com.example.notify.domain.notes.adapter.NotesRepository
import com.example.notify.domain.notes.model.Note
import kotlinx.coroutines.flow.Flow

class GetNoteByIdUseCaseImpl(
    private val notesRepository: NotesRepository
) : GetNoteByIdUseCase {
    override fun invoke(id: Int): Flow<Note> {
        return notesRepository.getNoteById(id)
    }
}