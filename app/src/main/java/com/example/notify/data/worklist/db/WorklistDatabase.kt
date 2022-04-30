package com.example.notify.data.worklist.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.notify.data.notes.db.Converters
import com.example.notify.data.worklist.model.WorklistEntity

@Database(entities = [WorklistEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class WorklistDatabase : RoomDatabase() {
    abstract fun worklistDao(): WorklistDao
}