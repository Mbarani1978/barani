package com.voiceshelldemo.voice

import android.content.Context
import android.speech.tts.TextToSpeech
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Locale
import javax.inject.Inject

class TextToSpeechManager @Inject constructor(@ApplicationContext private val context: Context) : TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null
    private var isReady = false
    private var currentProfile: TTSProfile = TTSProfile()

    init {
        tts = TextToSpeech(context, this)
    }

    override fun onInit(status: Int) {
        isReady = status == TextToSpeech.SUCCESS
        tts?.language = currentProfile.language
        tts?.setPitch(currentProfile.pitch)
        tts?.setSpeechRate(currentProfile.rate)
    }

    fun speak(text: String) {
        if (isReady) {
            tts?.language = currentProfile.language
            tts?.setPitch(currentProfile.pitch)
            tts?.setSpeechRate(currentProfile.rate)
            tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }

    fun setProfile(profile: TTSProfile) {
        currentProfile = profile
        if (isReady) {
            tts?.language = profile.language
            tts?.setPitch(profile.pitch)
            tts?.setSpeechRate(profile.rate)
        }
    }

    fun stop() {
        tts?.stop()
    }

    fun shutdown() {
        tts?.shutdown()
    }
}

// Customizable TTS profile
data class TTSProfile(
    val language: java.util.Locale = java.util.Locale.getDefault(),
    val pitch: Float = 1.0f,
    val rate: Float = 1.0f
)
}
