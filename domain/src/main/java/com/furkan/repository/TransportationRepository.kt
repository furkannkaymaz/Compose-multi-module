package com.furkan.repository

import com.furkan.model.TransportationModel

interface TransportationRepository {
    suspend fun getTransportationList() : TransportationModel
}