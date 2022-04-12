package com.example.notify.di.notes

import com.example.notify.domain.notes.adapter.NotesRepository
import com.example.notify.domain.notes.usecase.*
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

    @Provides
    fun provideDeleteNoteByIdUseCase(
        notesRepository: NotesRepository
    ): DeleteNoteByIdUseCase {
        return DeleteNoteByIdUseCaseImpl(notesRepository)
    }

    @Provides
    fun provideGetNoteByIdUseCase(
        notesRepository: NotesRepository
    ): GetNoteByIdUseCase {
        return GetNoteByIdUseCaseImpl(notesRepository)
    }

    @Provides
    fun provideUpdateNoteUseCase(
        notesRepository: NotesRepository
    ): UpdateNoteUseCase {
        return UpdateNoteUseCaseImpl(notesRepository)
    }
}