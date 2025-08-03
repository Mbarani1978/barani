package com.voiceshelldemo.voice

import java.util.Locale

class VoiceCommandParser {
    private val commands = mapOf(
        "open gmail" to "OPEN_GMAIL",
        "scroll down" to "SCROLL_DOWN",
        "what time is it" to "GET_TIME",
        "book a cab" to "BOOK_CAB",
        "help" to "HELP"
    )
    private val synonyms = mapOf(
        "gmail" to "open gmail",
        "down" to "scroll down",
        "cab" to "book a cab",
        "taxi" to "book a cab",
        "repeat" to "help"
    )

    fun parse(input: String): String {
        val normalized = input.trim().lowercase(Locale.getDefault())
        val command = commands.keys.find { normalized.contains(it) }
        if (command != null) return commands[command] ?: "UNKNOWN"
        val synonym = synonyms.keys.find { normalized.contains(it) }
        if (synonym != null) return commands[synonyms[synonym]] ?: "UNKNOWN"
        // Error-tolerant: re-prompt or clarify
        return "RETRY"
    }
}
