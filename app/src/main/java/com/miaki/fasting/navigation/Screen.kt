package com.miaki.fasting.navigation

sealed class Screen(val route: String) {
    data object splash: Screen("splash")
    data object dashboard: Screen("dashboard")
    data object login: Screen("login")
}