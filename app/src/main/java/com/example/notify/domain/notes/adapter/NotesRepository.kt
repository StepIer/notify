package com.example.notify.domain.notes.adapter

import com.example.notify.domain.notes.model.Note

interface NotesRepository {
    fun getAllNotes(): List<Note>
    fun insertNote(note: Note)
}