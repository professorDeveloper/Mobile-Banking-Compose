package com.azamovhudstc.mobilebankinguicompose.navigation

import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.flow.Flow

interface NavigationHandler {
    val navigationFlow: Flow<Navigator.() -> Unit>
}