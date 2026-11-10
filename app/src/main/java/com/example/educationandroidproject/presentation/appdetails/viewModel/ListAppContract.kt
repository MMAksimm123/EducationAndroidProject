package com.example.educationandroidproject.presentation.appdetails

import androidx.annotation.StringRes
import com.example.educationandroidproject.data.AppItem

sealed interface ListAppState {
    data object Loading : ListAppState
    data class Content(
        val apps: List<AppItem>,
        val ratings: Map<String, Float> = emptyMap()
    ) : ListAppState
    data class Error(val message: String) : ListAppState
}

sealed interface ListAppEvent {
    data object ShowSnackbar : ListAppEvent
}