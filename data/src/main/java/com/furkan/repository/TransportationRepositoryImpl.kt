package com.furkan.repository

import com.furkan.data_sources.TransportationLocalDataSources
import com.furkan.data_sources.TransportationRemoteDataSources
import com.furkan.model.TransportationModel
import javax.inject.Inject

/**
select and adjust data according to requests and conditions
 */

class TransportationRepositoryImpl @Inject constructor(
    private val remoteDataSources: TransportationRemoteDataSources,
    private val localDataSources: TransportationLocalDataSources
) : TransportationRepository {
    override suspend fun getTransportationList(): TransportationModel {
        return localDataSources.getTransportationList()
    }
}