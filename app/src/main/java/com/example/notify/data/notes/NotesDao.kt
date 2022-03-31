package com.example.notify.data.notes

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.notify.data.notes.model.NotesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes")
    fun getAllNotes(): Flow<List<NotesEntity>>

    @Insert
    fun insertNote(note: NotesEntity)
}