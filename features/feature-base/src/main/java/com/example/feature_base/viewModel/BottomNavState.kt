package com.example.feature_base.viewModel

import com.example.feature_base.bottomNav.BottomNavigationTab

data class BottomNavState(
    val selectedTab: BottomNavigationTab,
) : UiState {
    companion object {
        fun initial() = BottomNavState(BottomNavigationTab.HOME)
    }
}
