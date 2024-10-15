package com.miaki.fasting.navigation

import kotlinx.serialization.Serializable

sealed class Screen(val route: String) {
    data object splash: Screen("splash")
    data object dashboard: Screen("dashboard")
    data object login: Screen("login")
}

//deeplink routes
@Serializable
data class DetailScreen(val id: Int)