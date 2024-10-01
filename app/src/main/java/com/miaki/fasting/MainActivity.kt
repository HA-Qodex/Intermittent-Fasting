package com.miaki.fasting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.miaki.fasting.screens.dashboard.DashboardScreen
import com.miaki.fasting.ui.theme.IntermittentFastingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntermittentFastingTheme(darkTheme = false) {
//                LoginScreen()
                DashboardScreen()
            }
        }
    }
}