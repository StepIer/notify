package com.example.notify.domain.worklist.usecase

import com.example.notify.domain.worklist.adapter.WorklistRepository
import com.example.notify.domain.worklist.model.Worklist

class InsertWorklistUseCaseImpl(
    private val worklistRepository: WorklistRepository
) : InsertWorklistUseCase {

    override fun invoke(worklist: Worklist) {
        worklistRepository.insertWorklist(worklist)
    }
}