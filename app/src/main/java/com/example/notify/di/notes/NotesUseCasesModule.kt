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
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@InstallIn(SingletonComponent::class)
@Module
object NotesUseCasesModule {

    @Provides
    fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    fun provideGetAllNotesUseCase(
        notesRepository: NotesRepository,
        ioDispatcher: CoroutineDispatcher = Dispatchers.IO
    ): GetAllNotesUseCase {
        return GetAllNotesUseCaseImpl(notesRepository, ioDispatcher)
    }

    @Provides
    fun provideInsertNoteUseCase(
        notesRepository: NotesRepository,
        ioDispatcher: CoroutineDispatcher = Dispatchers.IO
    ): InsertNoteUseCase {
        return InsertNoteUseCaseImpl(notesRepository, ioDispatcher)
    }
}