package com.example.educationandroidproject.presentation.appdetails.viewModel

import com.example.educationandroidproject.data.AppItem

sealed interface InstallState {
    data object NotInstalled : InstallState
    data class Installing(val progress: Int) : InstallState
    data object Installed : InstallState
}

sealed interface AppDetailsState {
    data object Loading : AppDetailsState
    data class Error(val message: String) : AppDetailsState
    data class Content(
        val app: AppItem,
        val showcaseApps: List<AppItem>,
        val installState: InstallState = InstallState.NotInstalled
    ) : AppDetailsState
}