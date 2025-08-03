package com.voiceshelldemo.voice

import org.junit.Assert.*
import org.junit.Test

class VoiceCommandParserTest {
    private val parser = VoiceCommandParser()

    @Test
    fun testExactCommands() {
        assertEquals("OPEN_GMAIL", parser.parse("Open Gmail"))
        assertEquals("SCROLL_DOWN", parser.parse("Scroll down"))
        assertEquals("GET_TIME", parser.parse("What time is it"))
        assertEquals("BOOK_CAB", parser.parse("Book a cab"))
        assertEquals("HELP", parser.parse("Help"))
    }

    @Test
    fun testSynonyms() {
        assertEquals("OPEN_GMAIL", parser.parse("gmail"))
        assertEquals("SCROLL_DOWN", parser.parse("down"))
        assertEquals("BOOK_CAB", parser.parse("taxi"))
        assertEquals("HELP", parser.parse("repeat"))
    }

    @Test
    fun testUnknownCommand() {
        assertEquals("RETRY", parser.parse("foobar"))
    }
}
