package com.furkan.presentation.search

import androidx.lifecycle.viewModelScope
import com.furkan.presentation.base.BaseViewModel
import com.furkan.presentation.base.UIState
import com.furkan.uiModel.transportation.TransportationModelUi
import com.furkan.usecase.GetTransportationUseCase
import com.furkan.usecase.SearchTransportationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getTransportationUseCase: GetTransportationUseCase,
    private val searchTransportationUseCase: SearchTransportationUseCase
) : BaseViewModel<TransportationSearchState>() {

    override fun setInitialState() = TransportationSearchState.Loading(true)

    init {
        getTransportations()
    }

    private fun getTransportations() {
        viewModelScope.launch {
            getTransportationUseCase.invoke().collect {
                setState(TransportationSearchState.Loading(false))
                when (it) {
                    is GetTransportationUseCase.GetTransportationUseCaseState.Data -> {
                        setState(TransportationSearchState.TransportationDataSuccess(it.transportation))
                    }

                    is GetTransportationUseCase.GetTransportationUseCaseState.Error -> {
                        setState(TransportationSearchState.Error("Error Message"))
                    }
                }
            }
        }
    }

    fun onQueryTextChange(query: String) = viewModelScope.launch {
        if (query.length > 2) {
            setState(TransportationSearchState.Loading(true))
            delay(500)
            searchSatellites(query)
        } else {
            setState(TransportationSearchState.Loading(true))
            getTransportations()
        }
    }

    private fun searchSatellites(query: String) {
        viewModelScope.launch {
            searchTransportationUseCase.searchTransportationByType(query).collect() {
                setState(TransportationSearchState.Loading(false))
                when (it) {
                    is SearchTransportationUseCase.SearchTransportationUseCaseState.TransportationDataSuccess -> {
                        setState(TransportationSearchState.TransportationDataSuccess(it.transportation))
                    }

                    is SearchTransportationUseCase.SearchTransportationUseCaseState.Error -> {
                        setState(TransportationSearchState.Error("Error Message"))
                    }

                    SearchTransportationUseCase.SearchTransportationUseCaseState.TransportationDataNotFound-> {
                        setState(TransportationSearchState.Error("No Data Found"))
                    }
                }
            }
        }
    }
}

sealed class TransportationSearchState : UIState {
    data class Loading(val isLoading: Boolean) : TransportationSearchState()
    data class TransportationDataSuccess(val transportation: TransportationModelUi) :
        TransportationSearchState()

    data class Error(val message: String) : TransportationSearchState()
}