package com.example.notify.domain.notes.usecase

import com.example.notify.domain.notes.adapter.NotesRepository
import com.example.notify.domain.notes.model.Note

class UpdateNoteUseCaseImpl(
    private val notesRepository: NotesRepository
) : UpdateNoteUseCase {
    override fun invoke(note: Note) {
        notesRepository.updateNote(note)
    }
}