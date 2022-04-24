package com.example.notify.domain.worklist.usecase

interface DeleteWorklistByTitleUseCase {

    fun invoke(title: String)
}