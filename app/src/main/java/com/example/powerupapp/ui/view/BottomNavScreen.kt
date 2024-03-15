package com.example.powerupapp.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.feature.settings.view.SettingsScreen
import com.example.feature.settings.viewModel.SettingsItemsViewModelImpl
import com.example.feature_base.bottomNav.BottomNavigationTab
import com.example.feature_base.viewModel.BottomNavViewModelImpl
import com.example.powerupapp.HomePage
import com.example.powerupapp.ProfilePage


@Composable
fun BottomNavScreen(viewModelImpl: BottomNavViewModelImpl) {
    Box {
        val state by viewModelImpl.state.collectAsState()
        val navController = rememberNavController()
        val navGraph by remember(navController) {
            mutableStateOf(
                navController.createGraph(startDestination = BottomNavigationTab.HOME.route) {
                    composable(BottomNavigationTab.SETTINGS.route) {
                        SettingsScreen(SettingsItemsViewModelImpl())
                    }
                    composable(BottomNavigationTab.HOME.route) {
                        HomePage()
                    }
                    composable(BottomNavigationTab.PROFILE.route) {
                        ProfilePage()
                    }
                }
            )
        }
        NavHost(navController = navController, graph = navGraph)
        val navTabItems = BottomNavigationTab.entries
        NavigationBar(
            Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            navTabItems.forEach {
                NavigationBarItem(
                    selected = it == state.selectedTab,
                    onClick = {
                        navController.navigate(it.route); viewModelImpl.updateNavItemClicked(it)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = it.iconSelected),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                )
            }
        }
    }
}
