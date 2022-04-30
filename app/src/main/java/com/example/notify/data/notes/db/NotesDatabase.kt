package com.example.notify.data.notes.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.notify.data.notes.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
@TypeConverters(Converters::class, com.example.notify.data.Converters::class)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun notesDao(): NotesDao
}