package com.furkan.di

import com.furkan.base.BaseMapper
import com.furkan.mapper.TransportationMapper
import com.furkan.model.TransportationModel
import com.furkan.uiModel.TransportationModelUi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindInitModule(transportationMapper: TransportationMapper): BaseMapper<TransportationModel, TransportationModelUi>

}