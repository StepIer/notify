package com.example.notify.domain.worklist.usecase

import com.example.notify.domain.worklist.adapter.WorklistRepository

class DeleteEntryByIdUseCaseImpl(
    private val worklistRepository: WorklistRepository
) : DeleteEntryByIdUseCase {
    override fun invoke(id: Int) {
        worklistRepository.deleteEntryById(id)
    }
}