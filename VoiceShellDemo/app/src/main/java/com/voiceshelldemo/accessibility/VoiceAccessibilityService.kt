package com.voiceshelldemo.accessibility

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VoiceAccessibilityService : AccessibilityService() {
    override fun onServiceConnected() {
        val info = AccessibilityServiceInfo().apply {
            eventTypes = AccessibilityEvent.TYPE_VIEW_FOCUSED or AccessibilityEvent.TYPE_VIEW_CLICKED or AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED
            feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN
            notificationTimeout = 100
        }
        serviceInfo = info
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        event?.let {
            val label = getElementLabel(event)
            if (label.isNotEmpty()) {
                Toast.makeText(this, label, Toast.LENGTH_SHORT).show()
                // TODO: Announce label via TTS
            }
        }
    }

    override fun onInterrupt() {
        // Handle interruption (e.g., stop TTS)
    }

    private fun getElementLabel(event: AccessibilityEvent): String {
        val nodeInfo: AccessibilityNodeInfo? = event.source
        return nodeInfo?.contentDescription?.toString() ?: nodeInfo?.text?.toString() ?: ""
    }
}
