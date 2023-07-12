package com.furkan.presentation.detail

import androidx.lifecycle.viewModelScope
import com.furkan.presentation.base.BaseViewModel
import com.furkan.presentation.base.UIState
import com.furkan.uiModel.transportation_detail.TransportationUiDetail
import com.furkan.uiModel.transportation_detail.TransportationUiDetailItem
import com.furkan.usecase.GetTransportationDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getTransportationDetailUseCase: GetTransportationDetailUseCase
) : BaseViewModel<TransportationDetailState>() {

    override fun setInitialState() = TransportationDetailState.Loading(true)

     fun getTransportations(id: Int) {
        viewModelScope.launch {
            getTransportationDetailUseCase.invoke(id).collect {
                setState(TransportationDetailState.Loading(false))
                when (it) {
                    is GetTransportationDetailUseCase.GetTransportationDetailUseCaseState.Data -> {
                        setState(TransportationDetailState.TransportationDataSuccess(it.transportation))
                    }
                    is GetTransportationDetailUseCase.GetTransportationDetailUseCaseState.Error -> {
                        setState(TransportationDetailState.Error("Error Message"))
                    }
                }
            }
        }
    }
}

sealed class TransportationDetailState : UIState {
    data class Loading(val isLoading: Boolean) : TransportationDetailState()
    data class TransportationDataSuccess(val transportation: TransportationUiDetailItem) :
        TransportationDetailState()

    data class Error(val message: String) : TransportationDetailState()
}