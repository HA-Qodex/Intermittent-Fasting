package com.miaki.fasting.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miaki.fasting.ui.theme.Typography
import com.miaki.fasting.ui.theme.background

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardAppBar(
    context: Context,
//    navController: NavController,
) {
    TopAppBar(
        title = {
            Column(modifier = Modifier.wrapContentSize(), verticalArrangement = Arrangement.Top) {
                Row(
                    modifier = Modifier.wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ImageLoader(
                        context = context,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape),
                        contentDescription = "profile",
                        imageUrl = "https://img.freepik.com/premium-photo/most-beautiful-birds-world_966797-599.jpg"
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        "Huzaifa Ahmed",
                        style = Typography.bodyLarge.copy(fontSize = 16.sp)
                    )
                }
            }
    },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = background),
//        actions = {
//            IconButton(onClick = { openDatePickerDialog.value = true }) {
//                Icon(
//                    modifier = Modifier
//                        .size(30.dp),
//                    tint = TextColor,
//                    imageVector = Icons.Filled.CalendarMonth, contentDescription = "calender"
//                )
//            }
//            IconButton(onClick = { displayPopUpMenu = !displayPopUpMenu }) {
//                Icon(
//                    modifier = Modifier
//                        .size(30.dp),
//                    tint = TextColor,
//                    imageVector = Icons.Filled.Settings, contentDescription = "settings"
//                )
//            }
//            DropdownMenu(
//                modifier = Modifier
//                    .shadow(
//                        color = DarkBlack,
//                        borderRadius = 8.dp,
//                        spread = 2.dp,
//                        offsetX = 3.dp,
//                        offsetY = 3.dp,
//                        blurRadius = 5.dp
//                    )
//                    .background(TextColor),
//                expanded = displayPopUpMenu,
//                onDismissRequest = { displayPopUpMenu = false }
//            ) {
//                DropdownMenuItem(
//                    text = {
//                        Text("Profile", style = appTextStyle.copy(color = Color.Black))
//                    },
//                    leadingIcon = {
//                        if (userData.image == null || userData.image == "") {
//                            Icon(
//                                modifier = Modifier
//                                    .size(30.dp),
//                                tint = Color.Black,
//                                imageVector = Icons.Filled.Person,
//                                contentDescription = "profile"
//                            )
//                        } else {
//                            Image(
//                                bitmap = base64ToBitmap(userData.image!!),
//                                modifier = Modifier
//                                    .size(30.dp)
//                                    .clip(CircleShape),
//                                contentDescription = "profile",
//                                contentScale = ContentScale.FillBounds
//                            )
//                        }
//                    },
//                    onClick = {
//                        displayPopUpMenu = false
//                        navController.navigate(Screen.PROFILE.route)
//                    })
//                DropdownMenuItem(
//                    text = {
//                        Text("Leaderboard", style = appTextStyle.copy(color = Color.Black))
//                    },
//                    leadingIcon = {
//                        Icon(
//                            modifier = Modifier
//                                .size(30.dp),
//                            tint = Color.Black,
//                            imageVector = Icons.Outlined.EmojiEvents,
//                            contentDescription = "leaderboard"
//                        )
//                    },
//                    onClick = {
//                        displayPopUpMenu = false
//                        navController.navigate(Screen.LEADERBOARD.route)
//                    })
//                DropdownMenuItem(
//                    text = {
//                        Text("Subscription", style = appTextStyle.copy(color = Color.Black))
//                    },
//                    leadingIcon = {
//                        Icon(
//                            modifier = Modifier
//                                .size(30.dp),
//                            tint = Color.Black,
//                            imageVector = Icons.AutoMirrored.Filled.StickyNote2,
//                            contentDescription = "subscription"
//                        )
//                    },
//                    onClick = {
//                        displayPopUpMenu = false
//                        if (isNetworkAvailable(context)) {
//                            dashboardViewModel.setSubscription(false)
//                            navController.navigate("${Screen.PRICE_LIST.route}/appbar")
//                        } else {
//                            showNoInternetDialog.value = true
//                        }
//                    })
//                DropdownMenuItem(
//                    text = {
//                        Text("Redeem Coupon", style = appTextStyle.copy(color = Color.Black))
//                    },
//                    leadingIcon = {
//                        Icon(
//                            modifier = Modifier
//                                .size(30.dp),
//                            tint = Color.Black,
//                            imageVector = Icons.Filled.CardGiftcard,
//                            contentDescription = "redeem"
//                        )
//                    },
//                    onClick = {
//                        displayPopUpMenu = false
//                        navController.navigate(Screen.REDEEM.route)
//                    })
//                DropdownMenuItem(
//                    text = {
//                        Text("Settings", style = appTextStyle.copy(color = Color.Black))
//                    },
//                    leadingIcon = {
//                        Icon(
//                            modifier = Modifier
//                                .size(30.dp),
//                            tint = Color.Black,
//                            imageVector = Icons.Filled.SettingsSuggest,
//                            contentDescription = "settings"
//                        )
//                    },
//                    onClick = {
//                        displayPopUpMenu = false
//                        navController.navigate(Screen.SETTINGS.route)
//                    })
//                DropdownMenuItem(
//                    text = {
//                        Text("Logout", style = appTextStyle.copy(color = Color.Black))
//                    },
//                    leadingIcon = {
//                        Icon(
//                            modifier = Modifier
//                                .size(30.dp),
//                            tint = Color.Black,
//                            imageVector = Icons.AutoMirrored.Filled.Logout,
//                            contentDescription = "logout"
//                        )
//                    },
//                    onClick = {
//                        displayPopUpMenu = false
//                        if (isNetworkAvailable(context)) {
//                            saveData(sharedPref, "null")
//                            CoroutineScope(Dispatchers.Main).launch {
//                                dashboardViewModel.userSignOut(navController)
//                            }
//                        } else {
//                            showNoInternetDialog.value = true
//                        }
//                    })
//
//            }
//        }
    )
}