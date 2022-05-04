package com.example.notify.data.events.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.notify.data.events.model.EventEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EventsDao {

    @Query("SELECT * FROM events")
    fun getAllEvents(): Flow<List<EventEntity>>

    @Insert
    fun insertEvent(event: EventEntity)

    @Query("DELETE FROM events WHERE id = :id")
    fun deleteEventById(id: Int)

    @Query("SELECT * FROM events WHERE id = :id")
    fun getEventById(id: Int): Flow<EventEntity>

    @Update
    fun updateEvent(event: EventEntity)
}