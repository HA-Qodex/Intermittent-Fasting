package com.miaki.fasting.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miaki.fasting.ui.theme.Typography
import com.miaki.fasting.ui.theme.button
import com.miaki.fasting.ui.theme.white
import com.miaki.fasting.utils.AppUtil
import java.time.LocalDate

@Composable
fun HorizontalCalender(dates: State<List<List<LocalDate>>>) {
    val pagerState = rememberPagerState(
        initialPage = dates.value.size,
        pageCount = {
            dates.value.size
        })

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxWidth()
    ) { page ->
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            dates.value[page].forEach {date ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .weight(1f)
                        .clip(shape = RoundedCornerShape(5.dp))
                        .background(if (date == LocalDate.now()) button else white), contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.padding(vertical = 5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(AppUtil.formatDate(date, "MMM"), style = Typography.bodySmall.copy(fontSize = 12.sp, color = if (date == LocalDate.now()) white else button))
                        Text(
                            AppUtil.formatDate(date, "dd"),
                            style = Typography.bodyLarge.copy(fontSize = 24.sp,color = if (date == LocalDate.now()) white else button)
                        )
                        Text(AppUtil.formatDate(date, "EEE"), style = Typography.bodySmall.copy(fontSize = 12.sp, color = if (date == LocalDate.now()) white else button))
                    }
                }
            }
        }
    }
}