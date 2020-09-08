package com.gemidroid.gaads.base

import android.app.Application
import com.gemidroid.gaads.di.appModule
import com.gemidroid.gaads.di.leadersModule
import com.gemidroid.gaads.di.submissionModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        koinStart

    }

    private val koinStart = startKoin {
        androidLogger()
        androidContext(this@BaseApp)
        modules(appModule, leadersModule, submissionModule)
    }
}
