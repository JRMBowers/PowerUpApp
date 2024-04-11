package com.example.feature_base.bottomNav

import androidx.annotation.DrawableRes
import com.example.feature_base.R

enum class BottomNavigationTab(
    val title: String,
    @DrawableRes val iconSelected: Int,
    @DrawableRes val iconUnselected: Int,
    val route: String,
) {
    HOME(
        title = "Home",
        iconSelected = R.drawable.ic_home_page,
        iconUnselected = R.drawable.ic_home_page,
        route = "home",
    ),
    PROFILE(
        title = "Profile",
        iconSelected = R.drawable.ic_profile_page,
        iconUnselected = R.drawable.ic_profile_page,
        route = "profile",
    ),
    SETTINGS(
        title = "Settings",
        iconSelected = R.drawable.ic_settings,
        iconUnselected = R.drawable.ic_settings,
        route = "settings",
    ),
}
