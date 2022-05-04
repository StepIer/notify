package com.example.notify.di.events

import android.content.Context
import androidx.room.Room
import com.example.notify.data.events.db.EventsDao
import com.example.notify.data.events.db.EventsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object EventsDatabaseModule {

    @Provides
    @Singleton
    fun provideEventsDao(database: EventsDatabase): EventsDao {
        return database.eventsDao()
    }

    @Provides
    @Singleton
    fun provideNotesDatabase(@ApplicationContext appContext: Context): EventsDatabase {
        return Room.databaseBuilder(
            appContext,
            EventsDatabase::class.java,
            "events"
        ).build()
    }
}