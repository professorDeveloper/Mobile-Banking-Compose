package com.azamovhudstc.mobilebankinguicompose.di

import com.azamovhudstc.mobilebankinguicompose.repository.AuthRepository
import com.azamovhudstc.mobilebankinguicompose.repository.impl.AuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun getRepositoryAuth(repository: AuthRepositoryImpl):AuthRepository
}