package com.furkan.usecase

import com.furkan.mapper.TransportationMapper
import com.furkan.repository.TransportationRepository
import com.furkan.uiModel.TransportationModelUi
import javax.inject.Inject

class GetTransportationUseCase @Inject constructor(
    private val repository: TransportationRepository,
    private val mapper: TransportationMapper
) {
    suspend operator fun invoke(): TransportationModelUi {
        val response = repository.getTransportationList()
        return mapper.map(response)
    }
}