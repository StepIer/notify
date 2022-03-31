package com.example.notify.domain.notes.adapter

import com.example.notify.domain.notes.model.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    fun getAllNotes(): Flow<List<Note>>
    fun insertNote(note: Note)
}