package com.example.notify.data.worklist.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.notify.data.worklist.model.WorklistEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WorklistDao {

    @Query("SELECT * FROM worklist")
    fun getAllWorklist(): Flow<List<WorklistEntity>>

    @Insert
    fun insertWorklist(worklistEntity: WorklistEntity)

    @Query("DELETE FROM worklist WHERE title = :title")
    fun deleteWorklistByTitle(title: String)
}