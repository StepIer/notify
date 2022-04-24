package com.example.notify.data.worklist.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notify.data.worklist.model.WorklistEntity

@Database(entities = [WorklistEntity::class], version = 1)
abstract class WorklistDatabase : RoomDatabase() {
    abstract fun worklistDao(): WorklistDao
}