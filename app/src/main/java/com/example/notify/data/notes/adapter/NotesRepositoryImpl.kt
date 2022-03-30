package com.example.notify.data.notes.adapter

import com.example.notify.data.notes.NotesDao
import com.example.notify.data.notes.model.toDomainModel
import com.example.notify.domain.notes.adapter.NotesRepository
import com.example.notify.domain.notes.model.Notes

class NotesRepositoryImpl(
    private val notesDao: NotesDao
) : NotesRepository {
    override fun getAllNotes(): List<Notes> {
        return notesDao.getAllNotes().map {
            it.toDomainModel()
        }
    }
}