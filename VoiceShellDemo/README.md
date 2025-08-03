# VoiceShellDemo

VoiceShellDemo is a full-featured Android app in Kotlin that delivers a voice-only mobile shell with accessibility for elderly, blind, and low-literacy users.

## Features
- Voice-only control: All interactions via speech, all feedback via TTS
- Speaker authentication: Voiceprint registration and verification
- Multilingual support: Automatic language detection, on-the-fly translation
- MVVM architecture with Jetpack Compose and Hilt
- Secure on-device storage (encrypted)
- AccessibilityService for blind/low-vision users
- Guided wizard onboarding and error-tolerant parsing
- Customizable TTS profiles and offline speech models
- WCAG 2.1 compliance
- Ride-booking plugin (Ola, Uber, Local Auto)

## Setup
1. Open the project in Android Studio
2. Build and run on a device/emulator (minSdk 24)
3. Grant microphone, overlay, and usage-stats permissions

## Example Voice Commands
- "Open Gmail"
- "Scroll down"
- "What time is it?"
- "Book a cab to the hospital with Ola"
- "Help"

## Testing
Unit tests are provided for core modules (voice capture, auth, parser).

## Accessibility
- All UI elements have contentDescription
- AccessibilityEvents for toasts, dialogs, screen changes
- OCR/AI-powered image descriptions
- Haptic confirmations

## Security
- Voiceprints and translations stored encrypted on-device

## License
MIT
