package com.miaki.fasting.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miaki.fasting.repository.DashboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val dashboardRepository: DashboardRepository) :
    ViewModel() {
    val calenderDate: StateFlow<List<List<LocalDate>>> get() = dashboardRepository.calenderDate

    init {
        viewModelScope.launch {
            dashboardRepository.generateDate()
        }
    }

}