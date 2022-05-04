package com.example.notify.data.events.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.notify.data.LocalDateTimeConverters
import com.example.notify.data.events.model.EventEntity

@Database(entities = [EventEntity::class], version = 1)
@TypeConverters(LocalDateTimeConverters::class)
abstract class EventsDatabase : RoomDatabase() {
    abstract fun eventsDao(): EventsDao
}