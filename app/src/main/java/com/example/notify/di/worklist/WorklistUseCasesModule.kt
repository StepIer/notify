package com.example.notify.di.worklist

import com.example.notify.domain.worklist.adapter.WorklistRepository
import com.example.notify.domain.worklist.usecase.GetAllWorklistUseCase
import com.example.notify.domain.worklist.usecase.GetAllWorklistUseCaseImpl
import com.example.notify.domain.worklist.usecase.InsertWorklistUseCase
import com.example.notify.domain.worklist.usecase.InsertWorklistUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object WorklistUseCasesModule {

    @Provides
    fun provideGetAllWorklistUseCase(
        worklistRepository: WorklistRepository,
    ): GetAllWorklistUseCase {
        return GetAllWorklistUseCaseImpl(worklistRepository)
    }

    @Provides
    fun provideInsertWorklistUseCase(
        worklistRepository: WorklistRepository,
    ): InsertWorklistUseCase {
        return InsertWorklistUseCaseImpl(worklistRepository)
    }
}