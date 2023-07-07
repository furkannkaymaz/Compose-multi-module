package com.furkan.di

import com.furkan.api.TestApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
internal object ApiServiceModule {

    @Provides
    fun provideTestApiService(retrofit: Retrofit): TestApiService = retrofit.create()
}
