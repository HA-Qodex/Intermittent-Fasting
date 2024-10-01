package com.miaki.fasting.repository

import com.miaki.fasting.utils.AppUtil
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDate
import javax.inject.Inject

class DashboardRepository @Inject constructor() {
    private val _calenderDate = MutableStateFlow<List<List<LocalDate>>>(emptyList())
    val calenderDate: StateFlow<List<List<LocalDate>>> get() = _calenderDate

    suspend fun generateDate() {
        _calenderDate.emit(
            (AppUtil.generateDateList(
                AppUtil.getWeek(LocalDate.now().minusYears(1)).first,
                AppUtil.getWeek(LocalDate.now()).second
            )).chunked(7)
        )
    }
}