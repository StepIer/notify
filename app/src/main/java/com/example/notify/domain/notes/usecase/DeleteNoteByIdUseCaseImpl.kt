package com.example.notify.domain.notes.usecase

import com.example.notify.domain.notes.adapter.NotesRepository

class DeleteNoteByIdUseCaseImpl(
    val notesRepository: NotesRepository
) : DeleteNoteByIdUseCase {
    override suspend fun invoke(id: Int) {
        notesRepository.deleteNoteById(id)
    }
}