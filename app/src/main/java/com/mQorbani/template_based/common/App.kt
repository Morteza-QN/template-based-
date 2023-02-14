package com.mQorbani.template_based.common

import android.app.Application
import android.os.StrictMode
import com.mQorbani.template_based.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {
    private val isDebug = BuildConfig.DEBUG

    override fun onCreate() {
        enableScriptMode()
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        if (isDebug) Timber.plant(Timber.DebugTree())
    }

    private fun enableScriptMode() {
        if (isDebug) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build()
            )
            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build()
            )
        }
    }
}