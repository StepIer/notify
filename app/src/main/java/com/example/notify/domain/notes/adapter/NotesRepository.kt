package com.example.notify.domain.notes.adapter

import com.example.notify.domain.notes.model.Notes

interface NotesRepository {
    fun getAllNotes(): List<Notes>
}