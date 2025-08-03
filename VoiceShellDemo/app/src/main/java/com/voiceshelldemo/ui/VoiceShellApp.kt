package com.voiceshelldemo.ui

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.voiceshelldemo.MainViewModel

@Composable
fun VoiceShellApp(viewModel: MainViewModel) {
    Surface(color = MaterialTheme.colorScheme.background) {
        VoiceShellScreen(viewModel)
    }
}
