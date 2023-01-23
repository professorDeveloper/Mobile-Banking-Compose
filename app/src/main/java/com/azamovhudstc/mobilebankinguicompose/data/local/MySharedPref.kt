package com.azamovhudstc.mobilebankinguicompose.data.local

import android.content.Context
import android.content.SharedPreferences
import com.azamovhudstc.mobilebankinguicompose.utils.SharedPreference
import javax.inject.Inject

class MySharedPref @Inject constructor(context: Context, sharedPref: SharedPreferences) :
    SharedPreference(context, sharedPref) {
    var token: String by Strings("")
    var refreshToken: String by Strings("")
    var verifyToken:String by Strings("")
    var phone: String by Strings()
    var name: String by Strings("Username")
    var typeFont: Int by Ints(1)
    var themeIndex: Int by Ints(1)


}