package com.example.notify.data.worklist.adapter

import com.example.notify.data.worklist.db.EntryDao
import com.example.notify.data.worklist.db.WorklistDao
import com.example.notify.data.worklist.model.toDomain
import com.example.notify.domain.worklist.adapter.WorklistRepository
import com.example.notify.domain.worklist.model.Entry
import com.example.notify.domain.worklist.model.Worklist
import com.example.notify.domain.worklist.model.toData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WorklistRepositoryImpl(
    private val worklistDao: WorklistDao,
    private val entryDao: EntryDao
) : WorklistRepository {
    override fun getAllWorklist(): Flow<List<Worklist>> {
        return worklistDao.getAllWorklist().map { list ->
            list.map {
                it.toDomain()
            }
        }
    }

    override fun insertWorklist(worklist: Worklist) {
        worklistDao.insertWorklist(worklist.toData())
    }

    override fun deleteWorklistByTitle(title: String) {
        worklistDao.deleteWorklistByTitle(title)
    }

    override fun getAllEntryByWorklistName(worklistName: String): Flow<List<Entry>> {
        return entryDao.getAllEntryByWorklistName(worklistName).map { list ->
            list.map {
                it.toDomain()
            }
        }
    }

    override fun updateEntry(entry: Entry) {
        entryDao.updateNote(entry.toData())
    }

    override fun deleteEntryById(id: Int) {
        entryDao.deleteEntryById(id)
    }

    override fun insertEntry(entry: Entry) {
        entryDao.insertEntry(entry.toData())
    }
}