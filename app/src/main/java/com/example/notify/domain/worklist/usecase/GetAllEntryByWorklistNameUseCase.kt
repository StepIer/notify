package com.example.notify.domain.worklist.usecase

import com.example.notify.domain.worklist.model.Entry
import kotlinx.coroutines.flow.Flow

interface GetAllEntryByWorklistNameUseCase {
    fun invoke(worklistName: String): Flow<List<Entry>>
}