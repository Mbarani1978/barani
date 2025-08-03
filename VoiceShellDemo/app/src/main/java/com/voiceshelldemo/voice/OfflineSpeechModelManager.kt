package com.voiceshelldemo.voice

import android.content.Context
import org.tensorflow.lite.Interpreter
import java.io.File
import javax.inject.Inject

class OfflineSpeechModelManager @Inject constructor(private val context: Context) {
    private var interpreter: Interpreter? = null

    fun loadModel(modelFile: File) {
        interpreter = Interpreter(modelFile)
    }

    fun runInference(input: FloatArray): FloatArray? {
        val output = FloatArray(1)
        interpreter?.run(input, output)
        return output
    }

    fun release() {
        interpreter?.close()
        interpreter = null
    }
}
