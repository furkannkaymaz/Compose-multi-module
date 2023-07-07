package com.furkan.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.furkan.presentation.base.BaseViewModel
import com.furkan.presentation.base.UIState
import com.furkan.uiModel.TransportationModelUi
import com.furkan.usecase.GetTransportationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTransportationUseCase: GetTransportationUseCase
) : BaseViewModel<HomeViewModel.TransportationState>() {

    override fun setInitialState() = TransportationState.Loading(true)

    init {
        getTransportations()
    }

    private fun getTransportations() {
        viewModelScope.launch {
            getTransportationUseCase.invoke().collect{
                setState(TransportationState.Loading(false))
                when(it){
                    is GetTransportationUseCase.GetTransportationUseCaseState.Data -> {
                        setState(TransportationState.TransportationData(it.transportation))
                    }
                    is GetTransportationUseCase.GetTransportationUseCaseState.Error -> {
                        setState(TransportationState.Error("Error Message"))
                    }
                }
            }
        }
    }

    sealed interface TransportationState : UIState {
        data class Loading(val isLoading: Boolean) : TransportationState
        data class TransportationData(val transportation: TransportationModelUi) : TransportationState
        data class Error(val message: String) : TransportationState
    }


}