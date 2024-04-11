package com.example.feature_base.viewModel

import com.example.feature_base.bottomNav.BottomNavigationTab

class BottomNavViewModelImpl() : BaseViewModel<BottomNavState>(BottomNavState.initial()) {
    fun updateNavItemClicked(bottomNavigationTab: BottomNavigationTab) {
        setState { state.value.copy(selectedTab = bottomNavigationTab) }
    }
}
