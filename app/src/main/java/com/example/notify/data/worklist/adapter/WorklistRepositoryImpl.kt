package com.example.notify.data.worklist.adapter

import com.example.notify.data.worklist.db.WorklistDao
import com.example.notify.data.worklist.model.toDomain
import com.example.notify.domain.worklist.adapter.WorklistRepository
import com.example.notify.domain.worklist.model.Worklist
import com.example.notify.domain.worklist.model.toData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WorklistRepositoryImpl(
    private val worklistDao: WorklistDao
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
}