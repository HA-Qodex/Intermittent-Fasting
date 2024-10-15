package com.miaki.fasting.screens.dashboard

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.miaki.fasting.components.DashboardAppBar
import com.miaki.fasting.ui.theme.LightGray
import com.miaki.fasting.ui.theme.Typography
import com.miaki.fasting.ui.theme.background
import com.miaki.fasting.ui.theme.white
import com.miaki.fasting.viewmodels.DashboardViewModel

@Composable
fun DashboardScreen(navController: NavController) {
    val context = LocalContext.current
    val viewModel: DashboardViewModel = hiltViewModel()
    val calender = viewModel.calenderDate.collectAsState()

    var hasPermission by remember {
        mutableStateOf(
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                ContextCompat.checkSelfPermission(
                    context, Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED
            } else true
        )
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
    ) { isGranted ->
        hasPermission = isGranted
    }

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
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
                            .background(background)
                            .padding(bottom = 20.dp)
                    ) {
                        HorizontalCalender(calender)
                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier.padding(horizontal = 20.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
//                            Text(
//                                "Currently you are not following any fasting routine",
//                                style = Typography.bodyMedium.copy(
//                                    fontWeight = FontWeight.W500,
//                                    color = LightGray
//                                )
//                            )
                            if (hasPermission.not() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                Button(onClick = {
                                    permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                                }) {
                                    Text("Request Permission")
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}