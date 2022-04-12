package com.example.notify.domain.notes.usecase

interface DeleteNoteByIdUseCase {
    suspend fun invoke(id: Int)
}