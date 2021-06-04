package com.hemmati.farhangian.di

import com.hemmati.farhangian.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TIME_OUT = 30L
const val BASE_URL = BuildConfig.BASE_URL
const val BASE_URL2 = "https://google.com"

val NetworkModule = module {
//    single { createService(get()) }
    single(NetworkQualifiers.RETROFIT_1) { createRetrofit(get(), BASE_URL) }
    single(NetworkQualifiers.RETROFIT_2) { createRetrofit(get(), BASE_URL2) }
    single { createOkHttpClient() }

    single { GsonConverterFactory.create() }
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    HttpLoggingInterceptor.Level.BASIC.also { httpLoggingInterceptor.level = it }
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}

fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

/*fun createService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}*/



