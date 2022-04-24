package com.example.notify.domain.worklist.usecase

interface DeleteEntryByIdUseCase {
    fun invoke(id: Int)
}