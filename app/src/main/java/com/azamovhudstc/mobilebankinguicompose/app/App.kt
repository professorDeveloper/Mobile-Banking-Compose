package com.azamovhudstc.mobilebankinguicompose.app

import android.app.Application
import com.azamovhudstc.mobilebankinguicompose.data.local.TypeLocal
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App:Application(){
    companion object {
        lateinit var instance: App
    }
    override fun onCreate() {
        super.onCreate()
        TypeLocal.initPreferences(this)
        instance = this
    }

}