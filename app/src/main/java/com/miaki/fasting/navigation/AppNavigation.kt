package com.miaki.fasting.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute
import com.miaki.fasting.screens.DetailScreen
import com.miaki.fasting.screens.LoginScreen
import com.miaki.fasting.screens.dashboard.DashboardScreen

const val DEEPLINK_DOMAIN = "fasting.miaki.com"

@Composable
fun AppNavigation() {
    val navigationController = rememberNavController()

    NavHost(
        navController = navigationController,
        startDestination = Screen.dashboard.route
    ){
        composable(Screen.login.route) {
            LoginScreen(navigationController)
        }
        composable(Screen.dashboard.route) {
            DashboardScreen(navigationController)
        }

        composable<DetailScreen>(deepLinks = listOf( navDeepLink<DetailScreen>(
            basePath = "https://$DEEPLINK_DOMAIN"
        ))) {
            val id = it.toRoute<DetailScreen>().id
            DetailScreen(navigationController,id)
        }
    }

}