package com.example.notify.presentation.screens.events

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        makeStatusNotification(
            intent.getStringExtra("title") ?: "empty",
            intent.getStringExtra("message") ?: "empty",
            context
        )
    }
}