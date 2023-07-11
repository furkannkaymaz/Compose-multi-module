package com.furkan.usecase

import com.furkan.mapper.TransportationDetailMapper
import com.furkan.repository.TransportationRepository
import com.furkan.uiModel.transportation_detail.TransportationUiDetail
import com.furkan.utils.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTransportationDetailUseCase @Inject constructor(
    private val repository: TransportationRepository,
    private val mapper: TransportationDetailMapper
) {
    operator fun invoke(): Flow<GetTransportationDetailUseCaseState> = flow {
        repository.getTransportationDetailList().collect {
            when (it) {
                is Resource.Success -> {
                    emit(GetTransportationDetailUseCaseState.Data(mapper.map(it.data)))
                }

                is Resource.Error -> {
                    emit(GetTransportationDetailUseCaseState.Error(it.message))
                }
            }
        }
    }

    sealed class GetTransportationDetailUseCaseState {
        data class Data(val transportation: TransportationUiDetail) : GetTransportationDetailUseCaseState()
        data class Error(val message: String) : GetTransportationDetailUseCaseState()
    }
}