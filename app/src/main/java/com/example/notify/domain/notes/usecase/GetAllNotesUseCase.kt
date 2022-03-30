package com.example.notify.domain.notes.usecase

import com.example.notify.domain.notes.model.Notes

interface GetAllNotesUseCase {
    suspend fun invoke(): List<Notes>
}
