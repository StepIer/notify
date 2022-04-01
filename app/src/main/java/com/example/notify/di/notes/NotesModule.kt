package com.example.notify.di.notes

import com.example.notify.data.notes.adapter.NotesRepositoryImpl
import com.example.notify.data.notes.db.NotesDao
import com.example.notify.domain.notes.adapter.NotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object NotesModule {

    @Provides
    fun provideNotesRepository(
        notesDao: NotesDao
    ): NotesRepository {
        return NotesRepositoryImpl(
            notesDao
        )
    }
}
