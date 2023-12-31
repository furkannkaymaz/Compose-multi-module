package com.furkan.usecase

import com.furkan.compose_multi_module.domain.R
import com.furkan.core.infrastructure.StringResourceProvider
import com.furkan.repository.TransportationRepository
import com.furkan.uiModel.transportation_detail.TransportationUiDetailItem
import com.furkan.utils.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTransportationDetailUseCase @Inject constructor(
    private val repository: TransportationRepository,
    private val stringResourceProviderImpl: StringResourceProvider
) {
    operator fun invoke(id: Int): Flow<GetTransportationDetailUseCaseState> = flow {
        repository.getTransportationDetailList().collect {
            when (it) {
                is Resource.Success -> {
                    val filteredItem =
                        it.data.transportationDetail.find { listItem -> listItem.id == id }
                    if (filteredItem != null) {
                        emit(GetTransportationDetailUseCaseState.Data(filteredItem))
                    } else {
                        emit(
                            GetTransportationDetailUseCaseState.Error(
                                stringResourceProviderImpl.getString((R.string.txt_item_not_found)
                                )
                            )
                        )
                    }
                }

                is Resource.Error -> {
                    emit(GetTransportationDetailUseCaseState.Error(it.message))
                }
            }
        }
    }

    sealed class GetTransportationDetailUseCaseState {
        data class Data(val transportation: TransportationUiDetailItem) :
            GetTransportationDetailUseCaseState()

        data class Error(val message: String) : GetTransportationDetailUseCaseState()
    }
}