package com.furkan.usecase

import com.furkan.mapper.TransportationMapper
import com.furkan.repository.TransportationRepository
import com.furkan.uiModel.transportation.TransportationModelUi
import com.furkan.utils.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTransportationUseCase @Inject constructor(
    private val repository: TransportationRepository,
    private val mapper: TransportationMapper
) {
    operator fun invoke(): Flow<GetTransportationUseCaseState> = flow {
        repository.getTransportationList().collect {
            when (it) {
                is Resource.Success -> {
                    emit(GetTransportationUseCaseState.Data(mapper.map(it.data)))
                }

                is Resource.Error -> {
                    emit(GetTransportationUseCaseState.Error(it.message))
                }
            }
        }
    }

    sealed class GetTransportationUseCaseState {
        data class Data(val transportation: TransportationModelUi) : GetTransportationUseCaseState()
        data class Error(val message: String) : GetTransportationUseCaseState()
    }
}