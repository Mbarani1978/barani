package com.voiceshelldemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(VoiceShellUiState())
    val uiState: StateFlow<VoiceShellUiState> = _uiState

    fun onVoiceCommand(command: String) {
        viewModelScope.launch {
            // TODO: Parse and handle voice command
        }
    }
}

// Data class for UI state
 data class VoiceShellUiState(
    val lastCommand: String = "",
    val feedback: String = "Welcome to VoiceShellDemo!"
)
