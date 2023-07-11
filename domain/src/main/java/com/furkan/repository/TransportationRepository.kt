package com.furkan.repository

import com.furkan.model.transportation.TransportationModel
import com.furkan.model.transportation_detail.TransportationDetail
import com.furkan.utils.model.Resource
import kotlinx.coroutines.flow.Flow

interface TransportationRepository {
    suspend fun getTransportationList() : Flow<Resource<TransportationModel>>
    suspend fun getTransportationDetailList() : Flow<Resource<TransportationDetail>>
}