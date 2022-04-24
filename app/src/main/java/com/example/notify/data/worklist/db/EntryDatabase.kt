package com.example.notify.data.worklist.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notify.data.worklist.model.EntryEntity
import com.example.notify.data.worklist.model.WorklistEntity

@Database(entities = [EntryEntity::class, WorklistEntity::class], version = 1)
abstract class EntryDatabase : RoomDatabase() {
    abstract fun entryDao(): EntryDao
}