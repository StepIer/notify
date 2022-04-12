package com.example.notify.data.notes.adapter

import com.example.notify.data.notes.db.NotesDao
import com.example.notify.data.notes.model.toDomainModel
import com.example.notify.domain.notes.adapter.NotesRepository
import com.example.notify.domain.notes.model.Note
import com.example.notify.domain.notes.model.toDataModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NotesRepositoryImpl(
    private val notesDao: NotesDao
) : NotesRepository {
    override fun getAllNotes(): Flow<List<Note>> {
        return notesDao.getAllNotes().map { list ->
            list.map {
                it.toDomainModel()
            }
        }
    }

    override fun insertNote(note: Note) {
        notesDao.insertNote(note.toDataModel())
    }

    override fun deleteNoteById(id: Int) {
        notesDao.deleteNoteById(id)
    }

    override fun getNoteById(id: Int): Flow<Note> {
        return notesDao.getNoteById(id).map { it.toDomainModel() }
    }

    override fun updateNote(note: Note) {
        notesDao.updateNote(note.toDataModel())
    }
}