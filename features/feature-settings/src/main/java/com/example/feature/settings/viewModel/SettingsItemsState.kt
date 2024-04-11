package com.example.feature.settings.viewModel

import com.example.feature_base.viewModel.UiState
import com.example.powerupapp.settingsItems.model.SettingsItems

data class SettingsItemsState(
    val listOfItems: MutableList<Pair<SettingsItems, Boolean>>,
) : UiState {
    companion object {
        private val items = SettingsItemsState(listOfItems = SettingsItems.entries.map { Pair(it, false) }.toMutableList())

        fun initial() = items
    }
}
