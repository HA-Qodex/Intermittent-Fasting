package com.miaki.fasting

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.content.getSystemService
import androidx.core.net.toUri
import com.miaki.fasting.navigation.DEEPLINK_DOMAIN
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        showNotification()
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            "channel_id",
            "channel_name",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        val notificationManager = getSystemService<NotificationManager>()!!
        notificationManager.createNotificationChannel(channel)
    }

    private fun showNotification(){
        val activityIntent = Intent(this, MainActivity::class.java).apply {
            data = "https://$DEEPLINK_DOMAIN/64".toUri()
        }

        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(activityIntent)
            getPendingIntent(0, PendingIntent.FLAG_IMMUTABLE)
        }

        val notification = NotificationCompat.Builder(this, "channel_id")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("App Launched!")
            .setContentText("Tap to open deep link")
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .build()

        val notificationManager = getSystemService<NotificationManager>()!!
        notificationManager.notify(1, notification)
    }

}