package com.example.notify.domain.worklist.usecase

import com.example.notify.domain.worklist.adapter.WorklistRepository
import com.example.notify.domain.worklist.model.Entry

class InsertEntryUseCaseImpl(
    private val worklistRepository: WorklistRepository
) : InsertEntryUseCase {
    override fun invoke(entry: Entry) {
        worklistRepository.insertEntry(entry)
    }
}