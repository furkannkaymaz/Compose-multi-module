package com.furkan.di

import com.furkan.repository.TransportationRepository
import com.furkan.repository.TransportationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
 interface RepositoryModule {

    @Binds
    fun bindTransportationRepository(impl: TransportationRepositoryImpl): TransportationRepository

}
