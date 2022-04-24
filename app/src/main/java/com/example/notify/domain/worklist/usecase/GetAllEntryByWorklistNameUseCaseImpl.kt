package com.example.notify.domain.worklist.usecase

import com.example.notify.domain.worklist.adapter.WorklistRepository
import com.example.notify.domain.worklist.model.Entry
import kotlinx.coroutines.flow.Flow

class GetAllEntryByWorklistNameUseCaseImpl(
    private val worklistRepository: WorklistRepository
) : GetAllEntryByWorklistNameUseCase {
    override fun invoke(worklistName: String): Flow<List<Entry>> {
        return worklistRepository.getAllEntryByWorklistName(worklistName)
    }
}