package com.example.retrofitchapter7.network


import com.example.retrofitchapter7.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//object ApiClient {
//
//    const val BASE_URL = BuildConfig.BASE_URL
//
//    val logging: HttpLoggingInterceptor
//        get() {
//            val httpLoggingInterceptor = HttpLoggingInterceptor()
//            return httpLoggingInterceptor.apply {
//                level = HttpLoggingInterceptor.Level.BODY
//            }
//        }
//
//    private val client = OkHttpClient.Builder()
//        .addInterceptor(logging)
//        .build()
//
//    val instance: ApiService by lazy {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(client)
//            .build()
//
//        retrofit.create(ApiService::class.java)
//    }
//}