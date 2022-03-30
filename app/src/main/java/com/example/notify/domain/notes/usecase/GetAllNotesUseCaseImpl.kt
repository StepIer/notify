package com.example.notify.domain.notes.usecase

import com.example.notify.domain.notes.adapter.NotesRepository
import com.example.notify.domain.notes.model.Notes
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAllNotesUseCaseImpl(
    private val notesRepository: NotesRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : GetAllNotesUseCase {
    override suspend fun invoke(): List<Notes> = withContext(ioDispatcher) {
        notesRepository.getAllNotes()
    }
}