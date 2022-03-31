package com.example.notify.domain.notes.usecase

import com.example.notify.domain.notes.adapter.NotesRepository
import com.example.notify.domain.notes.model.Note
import kotlinx.coroutines.flow.Flow

class GetAllNotesUseCaseImpl(
    private val notesRepository: NotesRepository,
) : GetAllNotesUseCase {
    override fun invoke(): Flow<List<Note>> = notesRepository.getAllNotes()
}