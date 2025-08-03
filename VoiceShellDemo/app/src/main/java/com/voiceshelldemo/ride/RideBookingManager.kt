package com.voiceshelldemo.ride

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.location.Location
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class RideBookingManager @Inject constructor(@ApplicationContext private val context: Context) {
    fun bookCab(pickup: String, dropoff: String, vendor: RideVendor) {
        val uri = when (vendor) {
            RideVendor.OLA -> "https://book.olacabs.com/?pickup=$pickup&dropoff=$dropoff"
            RideVendor.UBER -> "https://m.uber.com/ul/?action=setPickup&pickup=$pickup&dropoff=$dropoff"
            RideVendor.AUTO -> "geo:0,0?q=auto+stand+near+$pickup"
        }
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}

enum class RideVendor {
    OLA, UBER, AUTO
}
