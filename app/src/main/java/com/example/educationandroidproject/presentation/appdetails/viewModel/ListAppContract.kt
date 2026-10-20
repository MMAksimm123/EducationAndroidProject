package com.example.educationandroidproject.presentation.appdetails

import androidx.annotation.StringRes
import com.example.educationandroidproject.data.AppItem

data class ListAppState(
    val apps: List<AppItem> = emptyList(),
    val isLoading: Boolean = true
)

sealed interface ListAppEvent {
    data class ShowSnackbar(@StringRes val message: Int) : ListAppEvent
}