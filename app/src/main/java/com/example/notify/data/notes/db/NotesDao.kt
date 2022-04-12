package com.example.notify.data.notes.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.notify.data.notes.model.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Insert
    fun insertNote(note: NoteEntity)

    @Query("DELETE FROM notes WHERE id = :id")
    fun deleteNoteById(id: Int)

    @Query("SELECT * FROM notes WHERE id = :id")
    fun getNoteById(id: Int): Flow<NoteEntity>

    @Update
    fun updateNote(note: NoteEntity)
}