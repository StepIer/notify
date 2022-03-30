package com.example.notify.data.notes

import androidx.room.Dao
import androidx.room.Query
import com.example.notify.data.notes.model.NotesEntity

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<NotesEntity>
}