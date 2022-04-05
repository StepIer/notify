package com.example.notify.domain.worklist.usecase

import com.example.notify.domain.worklist.adapter.WorklistRepository
import com.example.notify.domain.worklist.model.Worklist
import kotlinx.coroutines.flow.Flow

class GetAllWorklistUseCaseImpl(
    private val worklistRepository: WorklistRepository
) : GetAllWorklistUseCase {
    override fun invoke(): Flow<List<Worklist>> {
        return worklistRepository.getAllWorklist()
    }
}