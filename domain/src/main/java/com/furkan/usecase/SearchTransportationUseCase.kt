package com.furkan.usecase

import com.furkan.compose_multi_module.domain.R
import com.furkan.core.infrastructure.StringResourceProvider
import com.furkan.mapper.TransportationMapper
import com.furkan.repository.TransportationRepository
import com.furkan.uiModel.transportation.TransportationModelUi
import com.furkan.utils.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchTransportationUseCase @Inject constructor(
    private val repository: TransportationRepository,
    private val mapper: TransportationMapper,
    private val stringResourceProviderImpl: StringResourceProvider
) {
    fun searchTransportationByType(searchText: String): Flow<SearchTransportationUseCaseState> =
        flow {
            repository.getTransportationList().collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        val transportationModelUi = mapper.map(resource.data)
                        val filteredTransportation = transportationModelUi.transportation
                            ?.filter { transportation ->
                                transportation.type.contains(
                                    searchText,
                                    ignoreCase = true
                                )
                            }
                            ?: emptyList()
                        if (filteredTransportation.isNotEmpty()) {
                            emit(
                                SearchTransportationUseCaseState.TransportationDataSuccess(
                                    TransportationModelUi(filteredTransportation)
                                )
                            )
                        } else {
                            emit(
                                SearchTransportationUseCaseState.TransportationDataNotFound(
                                    stringResourceProviderImpl.getString(
                                        R.string.txt_item_not_found
                                    )
                                )
                            )
                        }
                    }

                    is Resource.Error -> {
                        emit(SearchTransportationUseCaseState.Error(resource.message))
                    }
                }
            }
        }

    sealed class SearchTransportationUseCaseState {
        data class TransportationDataSuccess(val transportation: TransportationModelUi) :
            SearchTransportationUseCaseState()

        data class TransportationDataNotFound(var message: String) :
            SearchTransportationUseCaseState()

        data class Error(val message: String) : SearchTransportationUseCaseState()
    }
}