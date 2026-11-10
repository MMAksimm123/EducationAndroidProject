package com.example.educationandroidproject.presentation.appdetails.viewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.domain.repository.AppRepository
import com.example.educationandroidproject.navigation.DetailDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: AppRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val destination = savedStateHandle.toRoute<DetailDestination>()

    private val _appData = MutableStateFlow<AppItem?>(null)
    val appData: StateFlow<AppItem?> = _appData.asStateFlow()

    private val _showcaseApps = MutableStateFlow<List<AppItem>>(emptyList())
    val showcaseApps: StateFlow<List<AppItem>> = _showcaseApps.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            runCatching {
                withContext(Dispatchers.IO) {
                    val app = repository.getAppById(destination.appId)
                    val showcase = repository.getApps()
                    Pair(app, showcase)
                }
            }.onSuccess { (app, showcase) ->
                _appData.value = app
                _showcaseApps.value = showcase
            }.onFailure { throwable ->
                if (throwable is CancellationException) throw throwable

                _errorMessage.value = "Не удалось загрузить данные: ${throwable.localizedMessage}"
                Log.e("DetailViewModel", "Error loading details", throwable)
            }
        }
    }
}