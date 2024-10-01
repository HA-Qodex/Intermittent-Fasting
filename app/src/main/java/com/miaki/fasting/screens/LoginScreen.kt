package com.miaki.fasting.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.miaki.fasting.R
import com.miaki.fasting.components.AppButton
import com.miaki.fasting.navigation.Screen
import com.miaki.fasting.ui.theme.Typography
import com.miaki.fasting.ui.theme.white
import com.miaki.fasting.viewmodels.AuthViewModel

@Composable
fun LoginScreen(navController: NavController) {
    val authViewModel: AuthViewModel = hiltViewModel()
    val context = LocalContext.current

    Scaffold(
        containerColor = white,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.padding(it)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    modifier = Modifier.size(250.dp),
                    painter = painterResource(R.drawable.fasting),
                    contentDescription = "background_image",
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text("Welcome", style = Typography.bodyLarge)
                Text("Please login to continue", style = Typography.bodyMedium)
                Spacer(modifier = Modifier.height(40.dp))
                AppButton(content = {
                    Row(
                        modifier = Modifier.wrapContentSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(R.drawable.google),
                            contentDescription = "Google", tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            "Login with Google",
                            style = Typography.bodyLarge.copy(fontSize = 16.sp)
                        )
                    }
                }) {
                    navController.navigate(Screen.dashboard.route)
//                    authViewModel.handleGoogleSignIn(context)
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    "By signing in you agree to our Term and privacy policy.",
                    style = Typography.bodySmall
                )
            }
        }
    }
}