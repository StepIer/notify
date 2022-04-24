package com.example.notify.domain.worklist.adapter

import com.example.notify.domain.worklist.model.Entry
import com.example.notify.domain.worklist.model.Worklist
import kotlinx.coroutines.flow.Flow

interface WorklistRepository {

    fun getAllWorklist(): Flow<List<Worklist>>
    fun insertWorklist(worklist: Worklist)
    fun deleteWorklistByTitle(title: String)

    fun getAllEntryByWorklistName(worklistName: String): Flow<List<Entry>>
    fun updateEntry(entry: Entry)
    fun deleteEntryById(id: Int)
    fun insertEntry(entry: Entry)
}