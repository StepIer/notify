package com.example.notify.domain.worklist.usecase

import com.example.notify.domain.worklist.adapter.WorklistRepository

class DeleteWorklistByTitleUseCaseImpl(
    private val worklistRepository: WorklistRepository
) : DeleteWorklistByTitleUseCase {
    override fun invoke(title: String) {
        worklistRepository.deleteWorklistByTitle(title)
    }
}