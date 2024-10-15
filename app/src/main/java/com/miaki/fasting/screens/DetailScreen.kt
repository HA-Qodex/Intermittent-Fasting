package com.miaki.fasting.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.miaki.fasting.ui.theme.white

@Composable
fun DetailScreen(navController: NavController, id: Int) {
    Scaffold(
        containerColor = white,
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(modifier = Modifier.padding(it)) {
            Text("Detail Screen - $id")
        }
    }
}