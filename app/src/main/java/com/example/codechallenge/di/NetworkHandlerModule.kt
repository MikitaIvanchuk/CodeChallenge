package com.example.codechallenge.di

import com.example.codechallenge.networkHandler.NetworkHandler
import com.example.codechallenge.networkHandler.NetworkHandlerImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface NetworkHandlerModule {

    @Singleton
    @Binds
    fun providesNetworkState(networkHandlerImpl: NetworkHandlerImpl): NetworkHandler
}
