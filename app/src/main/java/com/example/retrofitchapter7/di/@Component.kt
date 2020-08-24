package com.example.retrofitchapter7.di

import android.app.Application
import com.example.retrofitchapter7.BaseApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        ActivityModule::class,
        AndroidSupportInjectionModule::class,
        PresenterModule::class
    ]
)

interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent

    }

    fun inject(baseApp: BaseApp)

}