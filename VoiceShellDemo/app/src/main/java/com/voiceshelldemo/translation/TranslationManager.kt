package com.voiceshelldemo.translation

import android.content.Context
import com.google.cloud.translate.Translate
import com.google.cloud.translate.TranslateOptions
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Locale
import javax.inject.Inject

class TranslationManager @Inject constructor(@ApplicationContext private val context: Context) {
    private val translate: Translate = TranslateOptions.getDefaultInstance().service

    fun detectLanguage(text: String): String {
        val detection = translate.detect(text)
        return detection.language
    }

    fun translateText(text: String, targetLang: Locale): String {
        val translation = translate.translate(text, Translate.TranslateOption.targetLanguage(targetLang.language))
        return translation.translatedText
    }
}
