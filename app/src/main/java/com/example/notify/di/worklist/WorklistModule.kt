package com.example.notify.di.worklist

import com.example.notify.data.worklist.adapter.WorklistRepositoryImpl
import com.example.notify.data.worklist.db.WorklistDao
import com.example.notify.domain.worklist.adapter.WorklistRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object WorklistModule {

    @Provides
    fun provideWorklistRepository(
        worklistDao: WorklistDao
    ): WorklistRepository {
        return WorklistRepositoryImpl(
            worklistDao
        )
    }
}
