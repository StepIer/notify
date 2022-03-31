package com.example.notify.data.notes.adapter

import com.example.notify.data.notes.NotesDao
import com.example.notify.data.notes.model.toDomainModel
import com.example.notify.domain.notes.adapter.NotesRepository
import com.example.notify.domain.notes.model.Note
import com.example.notify.domain.notes.model.toDataModel

class NotesRepositoryImpl(
    private val notesDao: NotesDao
) : NotesRepository {
    override fun getAllNotes(): List<Note> {
        return notesDao.getAllNotes().map {
            it.toDomainModel()
        }
    }

    override fun insertNote(note: Note) {
        return notesDao.insertNote(note.toDataModel())
    }
}