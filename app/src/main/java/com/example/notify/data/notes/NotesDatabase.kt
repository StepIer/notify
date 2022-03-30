package com.example.notify.data.notes

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notify.data.notes.model.NotesEntity

@Database(entities = [NotesEntity::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun notesDao(): NotesDao
}