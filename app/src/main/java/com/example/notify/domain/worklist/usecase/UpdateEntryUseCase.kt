package com.example.notify.domain.worklist.usecase

import com.example.notify.domain.worklist.model.Entry

interface UpdateEntryUseCase {
    fun invoke(entry: Entry)
}