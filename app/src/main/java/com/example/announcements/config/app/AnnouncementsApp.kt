package com.example.announcements.config.app

import android.app.Application
import com.example.announcements.config.di.BaseModules
import org.koin.android.ext.android.startKoin

class AnnouncementsApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, BaseModules.getAllModules())
    }
}