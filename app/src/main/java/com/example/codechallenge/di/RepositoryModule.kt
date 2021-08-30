package com.example.codechallenge.di

import com.example.codechallenge.repository.EventRepository
import com.example.codechallenge.repository.EventRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Singleton
    @Binds
    fun providesRepository(eventRepositoryImpl: EventRepositoryImpl): EventRepository
}
