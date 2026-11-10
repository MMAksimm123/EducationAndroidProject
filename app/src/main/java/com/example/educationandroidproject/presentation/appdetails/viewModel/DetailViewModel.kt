package com.example.educationandroidproject.presentation.appdetails.viewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.educationandroidproject.domain.repository.AppRepository
import com.example.educationandroidproject.navigation.DetailDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: AppRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val destination = savedStateHandle.toRoute<DetailDestination>()

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state: StateFlow<AppDetailsState> = _state.asStateFlow()

    private var installJob: Job? = null

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            runCatching {
                val app = repository.getAppById(destination.appId)
                    ?: throw IllegalArgumentException("Приложение не найдено")
                val showcase = repository.getApps()
                Pair(app, showcase)
            }.onSuccess { (app, showcase) ->
                _state.value = AppDetailsState.Content(
                    app = app,
                    showcaseApps = showcase
                )
            }.onFailure { throwable ->
                if (throwable is CancellationException) throw throwable
                _state.value = AppDetailsState.Error("Не удалось загрузить данные: ${throwable.localizedMessage}")
                Log.e("DetailViewModel", "Error loading details", throwable)
            }
        }
    }

    fun onInstallClick() {
        val current = _state.value
        if (current !is AppDetailsState.Content) return

        if (current.installState is InstallState.Installing) {
            installJob?.cancel()
            _state.update {
                if (it is AppDetailsState.Content) it.copy(installState = InstallState.NotInstalled) else it
            }
        } else {
            installJob = viewModelScope.launch {
                emulateInstall()
            }
        }
    }

    private suspend fun emulateInstall() {
        try {
            for (progress in 0..100 step 5) {
                delay(150)

                _state.update { currentState ->
                    if (currentState is AppDetailsState.Content) {
                        currentState.copy(installState = InstallState.Installing(progress))
                    } else currentState
                }
            }
            _state.update { currentState ->
                if (currentState is AppDetailsState.Content) {
                    currentState.copy(installState = InstallState.Installed)
                } else currentState
            }
        } catch (e: CancellationException) {
            throw e
        }
    }
}