package com.voiceshelldemo.auth

import android.content.Context
import android.util.Base64
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.google.mlkit.common.MlKitException
import dagger.hilt.android.qualifiers.ApplicationContext
import org.tensorflow.lite.Interpreter
import java.io.File
import javax.inject.Inject

class VoiceAuthManager @Inject constructor(@ApplicationContext private val context: Context) {
    private val prefs by lazy {
        val masterKey = MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build()
        EncryptedSharedPreferences.create(
            context,
            "voice_auth_prefs",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    private var interpreter: Interpreter? = null

    fun registerVoiceprint(userId: String, voiceData: ByteArray) {
        val encoded = Base64.encodeToString(voiceData, Base64.DEFAULT)
        prefs.edit().putString("voiceprint_$userId", encoded).apply()
    }

    fun verifyVoice(userId: String, inputVoice: ByteArray): Boolean {
        val stored = prefs.getString("voiceprint_$userId", null) ?: return false
        val storedVoice = Base64.decode(stored, Base64.DEFAULT)
        // TODO: Use ML Kit or TensorFlow Lite to compare storedVoice and inputVoice
        return storedVoice.contentEquals(inputVoice) // Placeholder for demo
    }

    fun loadModel(modelFile: File) {
        interpreter = Interpreter(modelFile)
    }

    fun release() {
        interpreter?.close()
        interpreter = null
    }
}
