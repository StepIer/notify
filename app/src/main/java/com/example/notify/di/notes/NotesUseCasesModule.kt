package com.example.notify.di.notes

import com.example.notify.domain.notes.adapter.NotesRepository
import com.example.notify.domain.notes.usecase.GetAllNotesUseCase
import com.example.notify.domain.notes.usecase.GetAllNotesUseCaseImpl
import com.example.notify.domain.notes.usecase.InsertNoteUseCase
import com.example.notify.domain.notes.usecase.InsertNoteUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object NotesUseCasesModule {

    @Provides
    fun provideGetAllNotesUseCase(
        notesRepository: NotesRepository,
    ): GetAllNotesUseCase {
        return GetAllNotesUseCaseImpl(notesRepository)
    }

    @Provides
    fun provideInsertNoteUseCase(
        notesRepository: NotesRepository,
    ): InsertNoteUseCase {
        return InsertNoteUseCaseImpl(notesRepository)
    }
}