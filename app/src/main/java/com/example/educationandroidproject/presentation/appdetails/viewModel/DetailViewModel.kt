package com.example.educationandroidproject.presentation.appdetails.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.domain.repository.AppRepository
import com.example.educationandroidproject.navigation.DetailDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: AppRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val destination = savedStateHandle.toRoute<DetailDestination>()
    val appData: AppItem? = repository.getAppById(destination.appId)
    val showcaseApps: List<AppItem> = repository.getApps()
}