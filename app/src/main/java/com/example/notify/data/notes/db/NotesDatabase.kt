package com.example.notify.data.notes.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.notify.data.LocalDateTimeConverters
import com.example.notify.data.notes.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
@TypeConverters(PaintDataConverters::class, LocalDateTimeConverters::class)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun notesDao(): NotesDao
}