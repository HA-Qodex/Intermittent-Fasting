package com.miaki.fasting.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.miaki.fasting.components.DashboardAppBar
import com.miaki.fasting.ui.theme.background
import com.miaki.fasting.ui.theme.white
import com.miaki.fasting.viewmodels.DashboardViewModel

@Composable
fun DashboardScreen() {
    val context = LocalContext.current
    val viewModel: DashboardViewModel = hiltViewModel()
    val calender = viewModel.calenderDate.collectAsState()
    Scaffold(
        containerColor = white,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DashboardAppBar(context = context)
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
                        .background(background).padding(bottom = 20.dp)
                ) {
                    Column {
                        HorizontalCalender(calender)
                    }
                }
            }
        }
    }
}