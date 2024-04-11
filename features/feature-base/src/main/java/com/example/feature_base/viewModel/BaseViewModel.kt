package com.example.feature_base.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<S : UiState>(initialVal: S) : ViewModel() {
    private val _state: MutableStateFlow<S> = MutableStateFlow(initialVal)

    val state: StateFlow<S>
        get() = _state.asStateFlow()

    protected fun setState(newState: S.() -> S) {
        _state.update {
            it.newState()
        }
    }
}
