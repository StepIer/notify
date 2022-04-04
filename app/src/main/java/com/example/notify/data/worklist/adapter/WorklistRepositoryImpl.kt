package com.example.notify.data.worklist.adapter

import com.example.notify.data.worklist.db.WorklistDao
import com.example.notify.domain.worklist.adapter.WorklistRepository

class WorklistRepositoryImpl(
    private val worklistDao: WorklistDao
) : WorklistRepository {
}