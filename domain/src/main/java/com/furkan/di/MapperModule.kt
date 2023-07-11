package com.furkan.di

import com.furkan.base.BaseMapper
import com.furkan.mapper.TransportationDetailMapper
import com.furkan.mapper.TransportationMapper
import com.furkan.model.transportation.TransportationModel
import com.furkan.model.transportation_detail.TransportationDetail
import com.furkan.uiModel.transportation.TransportationModelUi
import com.furkan.uiModel.transportation_detail.TransportationUiDetail
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindTransportationModule(transportationMapper: TransportationMapper): BaseMapper<TransportationModel, TransportationModelUi>

    @Binds
    abstract fun bindTransportationDetailModule(transportationDetailMapper: TransportationDetailMapper): BaseMapper<TransportationDetail, TransportationUiDetail>

}