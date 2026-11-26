package com.example.educationandroidproject.presentation.appdetails.viewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.educationandroidproject.domain.repository.AppDetailsRepository
import com.example.educationandroidproject.domain.repository.AppRepository
import com.example.educationandroidproject.navigation.DetailDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: AppDetailsRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val destination = savedStateHandle.toRoute<DetailDestination>()
    private val appId = destination.appId

    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state: StateFlow<AppDetailsState> = _state.asStateFlow()

    private var installJob: Job? = null

    init {
        fetchData()
        observeAppDetails()
    }

    private fun fetchData() {
        viewModelScope.launch {
            runCatching {
                repository.fetchAndSaveAppDetails(appId)
            }.onFailure { throwable ->
                if (throwable is CancellationException) throw  throwable
                Log.e("DetailViewModel", "Ошибка сети: ${throwable.localizedMessage}")
            }
        }
    }

    private fun observeAppDetails() {
        viewModelScope.launch {
            repository.observeAppDetails(appId)
                .catch { e ->
                    _state.value = AppDetailsState.Error("Ошибка БД: ${e.message}")
                }
                .collect { appDetails ->
                    val currentInstallState = (_state.value as? AppDetailsState.Content)
                        ?.installState ?: InstallState.NotInstalled

                    _state.value = AppDetailsState.Content(
                        app = appDetails,
                        showcaseApps = (_state.value as? AppDetailsState.Content)
                            ?.showcaseApps ?: emptyList(),
                        installState = currentInstallState
                    )
                }
        }
    }

    fun toggleWishlist() {
        viewModelScope.launch {
            repository.toggleWishlist(appId)
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