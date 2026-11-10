package com.example.educationandroidproject.presentation.appdetails

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.educationandroidproject.domain.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.system.measureTimeMillis

@HiltViewModel
class ListAppViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<ListAppState>(ListAppState.Loading)
    val uiState: StateFlow<ListAppState> = _uiState.asStateFlow()

    private val _events = Channel<ListAppEvent>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        loadApps()
    }

    private fun loadApps() {
        viewModelScope.launch {
            _uiState.value = ListAppState.Loading
            runCatching {
                repository.getApps()
            }.onSuccess { apps ->
                _uiState.value = ListAppState.Content(apps)
            }.onFailure { throwable ->
                _uiState.value = ListAppState.Error(throwable.message ?: "Ошибка")
            }
        }
    }

    fun loadRatingsSequentially() {
        val currentState = _uiState.value
        if (currentState !is ListAppState.Content) return

        viewModelScope.launch {
            val time = measureTimeMillis {
                val rating = repository.loadRatingsSequentially(currentState.apps.map {
                    it.id
                })
                _uiState.value = currentState.copy(ratings = rating)
            }
            Log.d("RatingsTime", "Последовательно: $time мс")
            _events.send(ListAppEvent.ShowSnackbar)
        }
    }

    fun loadRatingsInParallel() {
        val currentState = _uiState.value
        if (currentState !is ListAppState.Content) return

        viewModelScope.launch {
            val time = measureTimeMillis {
                val rating = repository.loadRatingsInParallel(currentState.apps.map {
                    it.id
                })
                _uiState.value = currentState.copy(ratings = rating)
            }
            Log.d("RatingsTime", "Параллельно: $time мс")
            _events.send(ListAppEvent.ShowSnackbar)
        }
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _events.send(ListAppEvent.ShowSnackbar)
        }
    }
}