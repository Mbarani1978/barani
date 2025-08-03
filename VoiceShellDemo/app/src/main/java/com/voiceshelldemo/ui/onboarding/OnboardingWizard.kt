package com.voiceshelldemo.ui.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingWizard(
    onComplete: () -> Unit,
    onVoiceEnroll: () -> Unit
) {
    var step by remember { mutableStateOf(0) }
    val steps = listOf(
        "Welcome to VoiceShellDemo!",
        "Let's enroll your voice for secure access.",
        "Try saying a command: 'Open Gmail' or 'Book a cab.'",
        "You can ask for help anytime by saying 'Help.'"
    )
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = steps[step], style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))
        if (step == 1) {
            Button(onClick = onVoiceEnroll) { Text("Enroll Voice") }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (step < steps.size - 1) step++ else onComplete()
        }) {
            Text(if (step < steps.size - 1) "Next" else "Finish")
        }
    }
}
