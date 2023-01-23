package com.azamovhudstc.mobilebankinguicompose.navigation

import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyNavigationManager @Inject constructor() : NavigationHandler, AppNavigator {
    override val navigationFlow = MutableSharedFlow<Navigator.() -> Unit>()

    private suspend fun navigate(block: Navigator.() -> Unit) {
        navigationFlow.emit(block)
    }

    override suspend fun back() = navigate { pop() }
    override suspend fun navigationTo(screen: Screen) = navigate { push(screen) }
    override suspend fun replace(screen: Screen) = navigate { replace(screen) }
    override suspend fun replaceAll(screen: Screen) = navigate { replaceAll(screen) }
}

