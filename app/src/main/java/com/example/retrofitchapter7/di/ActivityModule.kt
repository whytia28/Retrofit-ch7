package com.example.retrofitchapter7.di

import com.example.retrofitchapter7.addperson.AddPersonActivity
import com.example.retrofitchapter7.edit.EditActivity
import com.example.retrofitchapter7.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun editActivity(): EditActivity

    @ContributesAndroidInjector
    abstract fun addPersonActivity(): AddPersonActivity
}