package com.furkan.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State : UIState> : ViewModel() {

    private val initialState: State by lazy { setInitialState() }

    abstract fun setInitialState(): State

    private val _state: MutableStateFlow<State> = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state

    fun setState(state: State) {
        viewModelScope.launch { _state.emit(state) }
    }

    fun getCurrentState() = state.value
}