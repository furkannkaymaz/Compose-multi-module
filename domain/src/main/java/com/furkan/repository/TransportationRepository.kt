package com.furkan.repository

import com.furkan.model.transportation.TransportationModel
import com.furkan.model.transportation_detail.TransportationDetail
import com.furkan.uiModel.transportation_detail.TransportationUiDetail
import com.furkan.utils.model.Resource
import kotlinx.coroutines.flow.Flow

interface TransportationRepository {
    fun getTransportationList() : Flow<Resource<TransportationModel>>
    fun getTransportationDetailList() : Flow<Resource<TransportationUiDetail>>
}