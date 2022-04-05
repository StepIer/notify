package com.example.notify.domain.worklist.usecase

import com.example.notify.domain.worklist.model.Worklist
import kotlinx.coroutines.flow.Flow

interface GetAllWorklistUseCase {
    fun invoke(): Flow<List<Worklist>>
}