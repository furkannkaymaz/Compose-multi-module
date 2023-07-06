package com.furkan.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.furkan.uiModel.TransportationModelUi
import com.furkan.usecase.GetTransportationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTransportationUseCase: GetTransportationUseCase
) : ViewModel() {

    private val _transportations: MutableStateFlow<TransportationModelUi?> = MutableStateFlow(
        TransportationModelUi()
    )
    val transportations = _transportations.asStateFlow()


    fun getTransportations() {
        viewModelScope.launch {
            _transportations.emit(getTransportationUseCase.invoke())
        }
    }
}