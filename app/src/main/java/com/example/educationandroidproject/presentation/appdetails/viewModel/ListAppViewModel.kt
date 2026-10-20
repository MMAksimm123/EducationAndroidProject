package com.example.educationandroidproject.presentation.appdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.educationandroidproject.R
import com.example.educationandroidproject.data.SampleApps
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class ListAppViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ListAppState())
    val uiState: StateFlow<ListAppState> = _uiState.asStateFlow()

    private val _events = Channel<ListAppEvent>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        loadApps()
    }

    private fun loadApps() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            delay(1000)

            _uiState.value = ListAppState(
                apps = SampleApps.apps,
                isLoading = false
            )
        }
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _events.send(ListAppEvent.ShowSnackbar(R.string.message_event))
        }
    }
}