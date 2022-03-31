package com.example.notify.domain.notes.usecase

import com.example.notify.domain.notes.adapter.NotesRepository
import com.example.notify.domain.notes.model.Note
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InsertNoteUseCaseImpl(
    private val notesRepository: NotesRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : InsertNoteUseCase {
    override suspend fun invoke(note: Note) {
        withContext(ioDispatcher) {
            notesRepository.insertNote(note)
        }
    }
}