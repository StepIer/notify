package com.example.notify.di.worklist

import android.content.Context
import androidx.room.Room
import com.example.notify.data.worklist.db.EntryDao
import com.example.notify.data.worklist.db.EntryDatabase
import com.example.notify.data.worklist.db.WorklistDao
import com.example.notify.data.worklist.db.WorklistDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object WorklistDatabaseModule {

    @Provides
    @Singleton
    fun provideWorklistDao(database: WorklistDatabase): WorklistDao {
        return database.worklistDao()
    }

    @Provides
    @Singleton
    fun provideWorklistDatabase(@ApplicationContext appContext: Context): WorklistDatabase {
        return Room.databaseBuilder(
            appContext,
            WorklistDatabase::class.java,
            "worklist"
        ).build()
    }

    @Provides
    @Singleton
    fun provideEntryDao(database: EntryDatabase): EntryDao {
        return database.entryDao()
    }

    @Provides
    @Singleton
    fun provideEntryDatabase(@ApplicationContext appContext: Context): EntryDatabase {
        return Room.databaseBuilder(
            appContext,
            EntryDatabase::class.java,
            "entry"
        ).build()
    }
}