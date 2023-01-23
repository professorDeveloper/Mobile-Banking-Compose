package com.azamovhudstc.mobilebankinguicompose.di

import com.azamovhudstc.mobilebankinguicompose.navigation.AppNavigator
import com.azamovhudstc.mobilebankinguicompose.navigation.MyNavigationManager
import com.azamovhudstc.mobilebankinguicompose.navigation.NavigationHandler
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    fun bindNavigationHandler(impl: MyNavigationManager): NavigationHandler

    @Binds
    fun bindAppNavigator(impl: MyNavigationManager): AppNavigator
}