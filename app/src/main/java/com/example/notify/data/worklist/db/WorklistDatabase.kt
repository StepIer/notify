package com.example.notify.data.worklist.db

import androidx.room.Database
import com.example.notify.data.worklist.model.EntryEntity
import com.example.notify.data.worklist.model.WorklistEntity

@Database(entities = [EntryEntity::class, WorklistEntity::class], version = 1)
abstract class WorklistDatabase {
    abstract fun worklistDao(): WorklistDao
}