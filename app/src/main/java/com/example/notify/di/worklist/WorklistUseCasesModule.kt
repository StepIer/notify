package com.example.notify.di.worklist

import com.example.notify.domain.worklist.adapter.WorklistRepository
import com.example.notify.domain.worklist.usecase.*
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

    @Provides
    fun provideDeleteWorklistByTitleUseCase(
        worklistRepository: WorklistRepository,
    ): DeleteWorklistByTitleUseCase {
        return DeleteWorklistByTitleUseCaseImpl(worklistRepository)
    }

    @Provides
    fun provideGetAllEntryByWorklistNameUseCase(
        worklistRepository: WorklistRepository,
    ): GetAllEntryByWorklistNameUseCase {
        return GetAllEntryByWorklistNameUseCaseImpl(worklistRepository)
    }

    @Provides
    fun provideInsertEntryUseCase(
        worklistRepository: WorklistRepository,
    ): InsertEntryUseCase {
        return InsertEntryUseCaseImpl(worklistRepository)
    }

    @Provides
    fun provideDeleteEntryByIdUseCase(
        worklistRepository: WorklistRepository,
    ): DeleteEntryByIdUseCase {
        return DeleteEntryByIdUseCaseImpl(worklistRepository)
    }

    @Provides
    fun provideUpdateEntryUseCase(
        worklistRepository: WorklistRepository,
    ): UpdateEntryUseCase {
        return UpdateEntryUseCaseImpl(worklistRepository)
    }
}