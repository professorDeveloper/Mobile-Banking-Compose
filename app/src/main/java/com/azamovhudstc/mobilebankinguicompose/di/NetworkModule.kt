package com.azamovhudstc.mobilebankinguicompose.di

import android.content.Context
import android.content.SharedPreferences
import com.azamovhudstc.mobilebankinguicompose.data.local.MySharedPref
import com.azamovhudstc.mobilebankinguicompose.data.remote.api.AuthApi
import com.azamovhudstc.mobilebankinguicompose.data.remote.api.CardApi
import com.azamovhudstc.mobilebankinguicompose.data.remote.api.HomeApi
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "http://143.198.48.222:84/"

    private const val CONNECTION_TIME_OUT = 5000L

    @[Provides Singleton]
    fun provideGson(): Gson = GsonBuilder().create()

    @[Provides Singleton Named(value = "mainApi")]
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()

    @[Provides Singleton]
    fun provideClient(
        @ApplicationContext context: Context,
        mySharedPref: MySharedPref
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor.Builder(context).build())
            .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.MILLISECONDS)
            .addInterceptor { chain ->
                val requestBuilder = chain.request().newBuilder()
                if (mySharedPref.token.isNotEmpty())
                    requestBuilder.addHeader("Authorization", "Bearer ${mySharedPref.token}")
                chain.proceed(requestBuilder.build())
            }
            .readTimeout(CONNECTION_TIME_OUT, TimeUnit.MILLISECONDS)
            .build()

    @[Provides Singleton]
    fun provideAuthApi(@Named("mainApi") retrofit: Retrofit): AuthApi =
        retrofit.create(AuthApi::class.java)
    @[Provides Singleton]
    fun provideHomeApi(retrofit: Retrofit): HomeApi = retrofit.create(HomeApi::class.java)

    @[Provides Singleton]
    fun provideCardApi(retrofit: Retrofit): CardApi = retrofit.create(CardApi::class.java)


    @[Provides Singleton]
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("app_data", Context.MODE_PRIVATE)

    @[Provides Singleton]
    fun provideSharedPrefs(
        @ApplicationContext context: Context,
        sharedPreferences: SharedPreferences
    ): MySharedPref =
        MySharedPref(context, sharedPreferences)

}