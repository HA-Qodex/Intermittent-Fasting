package com.miaki.fasting.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.miaki.fasting.screens.LoginScreen
import com.miaki.fasting.screens.dashboard.DashboardScreen

@Composable
fun AppNavigation() {
    val navigationController = rememberNavController()

    NavHost(
        navController = navigationController,
        startDestination = Screen.login.route
    ){
        composable(Screen.login.route) {
            LoginScreen(navigationController)
        }
        composable(Screen.dashboard.route) {
            DashboardScreen(navigationController)
        }
    }

}