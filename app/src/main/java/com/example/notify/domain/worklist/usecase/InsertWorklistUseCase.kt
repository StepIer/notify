package com.example.notify.domain.worklist.usecase

import com.example.notify.domain.worklist.model.Worklist

interface InsertWorklistUseCase {

    fun invoke(worklist: Worklist)
}