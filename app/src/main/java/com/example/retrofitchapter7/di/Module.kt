package com.example.retrofitchapter7.di

import com.example.retrofitchapter7.BuildConfig
import com.example.retrofitchapter7.addperson.AddPersonPresenter
import com.example.retrofitchapter7.edit.EditPersonPresenter
import com.example.retrofitchapter7.main.MainPresenter
import com.example.retrofitchapter7.network.ApiService
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = BuildConfig.BASE_URL
val appModule: Module = module {

    single {
        OkHttpClient.Builder()
            .build()
    }

    factory<ApiService> {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()

        retrofit.create(ApiService::class.java)

    }

    factory { (listener: MainPresenter.Listener) ->
        MainPresenter(listener, get())
    }

    factory { (listener: EditPersonPresenter.Listener) ->
        EditPersonPresenter(listener, get())
    }

    factory { (listener: AddPersonPresenter.Listener) ->
        AddPersonPresenter(listener, get())
    }
}