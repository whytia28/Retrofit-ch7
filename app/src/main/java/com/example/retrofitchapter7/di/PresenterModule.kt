package com.example.retrofitchapter7.di

import com.example.retrofitchapter7.addperson.AddPersonPresenter
import com.example.retrofitchapter7.edit.EditPersonPresenter
import com.example.retrofitchapter7.main.MainPresenter
import com.example.retrofitchapter7.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Singleton
    @Provides
    fun provideMainPresenter(apiService: ApiService): MainPresenter {
        return MainPresenter(apiService)
    }

    @Singleton
    @Provides
    fun provideAddPresenter(apiService: ApiService): AddPersonPresenter {
        return AddPersonPresenter(apiService)
    }

    @Singleton
    @Provides
    fun provideEditPresenter(apiService: ApiService): EditPersonPresenter {
        return EditPersonPresenter(apiService)
    }
}
