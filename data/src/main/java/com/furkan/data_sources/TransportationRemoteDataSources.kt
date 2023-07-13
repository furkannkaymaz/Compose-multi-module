package com.furkan.data_sources

import com.furkan.api.TransportationApiService
import com.furkan.model.transportation.TransportationModel
import javax.inject.Inject

/**
 * If you wants to use an service,  actions can be taken here
 */
class TransportationRemoteDataSources @Inject constructor(private val transportationApiService: TransportationApiService) {

     suspend fun getTransportationList() : TransportationModel {
        return transportationApiService.getTransportations()
    }
}