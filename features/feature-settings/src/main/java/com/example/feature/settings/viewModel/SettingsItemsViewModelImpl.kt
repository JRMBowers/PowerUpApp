package com.example.feature.settings.viewModel

import androidx.lifecycle.ViewModel
import com.example.powerupapp.settingsItems.model.SettingsItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class SettingsItemsViewModelImpl @Inject constructor(): ViewModel(){
    private val _state: MutableStateFlow<SettingsItemsState> = MutableStateFlow(SettingsItemsState.initial())

    val state: StateFlow<SettingsItemsState>
        get() = _state.asStateFlow()

    private fun setState(newState: SettingsItemsState) {
        _state.value = newState
    }

    fun settingsItemToggled(item: SettingsItems){
        val currentItems = state.value.listOfItems
        val updateItem = currentItems.map { if (it.first.name == item.name) Pair(item, !it.second) else it }.toMutableList()
        setState(state.value.copy(listOfItems = updateItem))
    }
}
