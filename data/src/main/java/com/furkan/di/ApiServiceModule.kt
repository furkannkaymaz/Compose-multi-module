package com.furkan.di

import com.furkan.api.TransportationApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {

    @Provides
    fun provideTransportationApiService(retrofit: Retrofit): TransportationApiService = retrofit.create()
}
