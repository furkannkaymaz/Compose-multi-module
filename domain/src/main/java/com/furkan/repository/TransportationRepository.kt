package com.furkan.repository

import com.furkan.model.TransportationModel
import com.furkan.utils.Resource
import kotlinx.coroutines.flow.Flow

interface TransportationRepository {
    suspend fun getTransportationList() : Flow<Resource<TransportationModel>>
}