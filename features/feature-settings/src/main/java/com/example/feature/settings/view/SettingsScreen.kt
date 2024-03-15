package com.example.feature.settings.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ListItem
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import com.example.feature.settings.viewModel.SettingsItemsViewModelImpl
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString

@Composable
fun SettingsScreen(
    settingsItemsViewModelImpl: SettingsItemsViewModelImpl
) {
    val state by settingsItemsViewModelImpl.state.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(
            text = AnnotatedString("SETTINGS PAGE!")
        )

        state.listOfItems.forEach { item ->
            ListItem(headlineContent = { Text(text = item.first.item) },
                trailingContent = {
                    Switch(
                        checked = item.second,
                        onCheckedChange = { settingsItemsViewModelImpl.settingsItemToggled(item.first)})
                })
        }
    }
}