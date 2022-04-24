package com.example.notify.domain.worklist.usecase

import com.example.notify.domain.worklist.model.Entry

interface InsertEntryUseCase {
    fun invoke(entry: Entry)
}