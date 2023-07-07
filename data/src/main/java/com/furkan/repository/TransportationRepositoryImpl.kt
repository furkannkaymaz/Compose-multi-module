package com.furkan.repository

import com.furkan.data_sources.TransportationLocalDataSources
import com.furkan.data_sources.TransportationRemoteDataSources
import com.furkan.model.TransportationModel
import com.furkan.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
select and adjust data according to requests and conditions
 */

class TransportationRepositoryImpl @Inject constructor(
    private val remoteDataSources: TransportationRemoteDataSources,
    private val localDataSources: TransportationLocalDataSources
) : TransportationRepository {
    override suspend fun getTransportationList() = flow<Resource<TransportationModel>> {
        emit(Resource.Success(localDataSources.getTransportationList()))
    }.catch {
        emit(Resource.Error("Error message"))
    }
}