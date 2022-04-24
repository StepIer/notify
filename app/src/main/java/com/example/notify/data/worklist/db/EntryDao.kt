package com.example.notify.data.worklist.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.notify.data.worklist.model.EntryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EntryDao {

    @Query("SELECT * FROM entry WHERE worklist = :worklistName")
    fun getAllEntryByWorklistName(worklistName: String): Flow<List<EntryEntity>>

    @Insert
    fun insertEntry(entryEntity: EntryEntity)

    @Query("DELETE FROM entry WHERE id = :id")
    fun deleteEntryById(id: Int)

    @Update
    fun updateNote(entryEntity: EntryEntity)
}