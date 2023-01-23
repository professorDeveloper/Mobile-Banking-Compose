package com.azamovhudstc.mobilebankinguicompose.data.local

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

object TypeLocal {
    private var sharedPreferences: SharedPreferences? = null

    fun initPreferences(context: Context) {
        if (sharedPreferences == null) sharedPreferences =
            context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
    }
    var themeIndex   set(value) = sharedPreferences!!.edit().putInt("typeIndex", value).apply()
        get() = sharedPreferences!!.getInt("typeIndex", 0)

    var typeFont   set(value) = sharedPreferences!!.edit().putInt("typeFont", value).apply()
        get() = sharedPreferences!!.getInt("typeFont", 1)




}

