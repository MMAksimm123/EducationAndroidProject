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
                withContext(Dispatchers.IO) {
                    repository.getApps()
                }
            }.onSuccess { apps ->
                _uiState.value = ListAppState.Content(apps)
            }.onFailure { throwable ->
                if (throwable is CancellationException) throw throwable

                _uiState.value = ListAppState.Error
                Log.e("ListAppViewModel", "Error loading apps", throwable)
            }
        }
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _events.send(ListAppEvent.ShowSnackbar)
        }
    }
}