package com.example.notify.presentation.screens.events

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class NotifyWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        makeStatusNotification("jkskjfdnvkjdnfvkjdnf", applicationContext)
        return Result.success()
    }
}