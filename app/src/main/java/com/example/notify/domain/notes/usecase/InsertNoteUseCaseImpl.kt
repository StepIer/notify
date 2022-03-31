package com.example.notify.domain.notes.usecase

import com.example.notify.domain.notes.adapter.NotesRepository
import com.example.notify.domain.notes.model.Note

class InsertNoteUseCaseImpl(
    private val notesRepository: NotesRepository,
) : InsertNoteUseCase {
    override fun invoke(note: Note) {
        notesRepository.insertNote(note)
    }
}