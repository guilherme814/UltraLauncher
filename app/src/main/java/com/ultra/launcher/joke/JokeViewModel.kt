package com.ultra.launcher.joke

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class JokeUiState(
    val joke: String = "Loading...",
    val isLoading: Boolean = false,
    val error: String? = null,
    val category: String = ""
)

class JokeViewModel(private val repository: JokeRepository = JokeRepository()) : ViewModel() {
    private val _uiState = MutableStateFlow(JokeUiState())
    val uiState: StateFlow<JokeUiState> = _uiState

    init {
        loadJoke()
    }

    fun loadJoke() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            
            repository.getRandomJoke().onSuccess { response ->
                _uiState.value = _uiState.value.copy(
                    joke = response.getFullJoke(),
                    category = response.category,
                    isLoading = false,
                    error = null
                )
            }.onFailure { exception ->
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = exception.message ?: "Unknown error"
                )
            }
        }
    }
}
