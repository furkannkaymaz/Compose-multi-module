package com.furkan.repository

import com.furkan.data_sources.TransportationLocalDataSources
import com.furkan.data_sources.TransportationRemoteDataSources
import com.furkan.mapper.TransportationDetailMapper
import com.furkan.model.transportation.TransportationModel
import com.furkan.model.transportation_detail.TransportationDetail
import com.furkan.uiModel.transportation_detail.TransportationUiDetail
import com.furkan.utils.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
select and adjust data according to requests and conditions
 */

class TransportationRepositoryImpl @Inject constructor(
    private val remoteDataSources: TransportationRemoteDataSources,
    private val localDataSources: TransportationLocalDataSources,
    private val mapper: TransportationDetailMapper
) : TransportationRepository {

    override fun getTransportationList() = flow<Resource<TransportationModel>> {
        emit(Resource.Success(localDataSources.getTransportationList()))
    }.catch {
        emit(Resource.Error("Error message"))
    }

    override fun getTransportationDetailList() = flow<Resource<TransportationUiDetail>> {
        emit(Resource.Success(mapper.map(localDataSources.getTransportationDetailList())))
    }.catch {
        emit(Resource.Error("Error message"))
    }
}