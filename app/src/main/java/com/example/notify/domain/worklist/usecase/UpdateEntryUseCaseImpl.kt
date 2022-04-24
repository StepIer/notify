package com.example.notify.domain.worklist.usecase

import com.example.notify.domain.worklist.adapter.WorklistRepository
import com.example.notify.domain.worklist.model.Entry

class UpdateEntryUseCaseImpl(
    private val worklistRepository: WorklistRepository
) : UpdateEntryUseCase {
    override fun invoke(entry: Entry) {
        worklistRepository.updateEntry(entry)
    }
}