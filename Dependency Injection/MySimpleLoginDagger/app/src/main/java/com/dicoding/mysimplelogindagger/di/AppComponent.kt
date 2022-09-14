package com.dicoding.mysimplelogindagger.di

import android.content.Context
import com.dicoding.mysimplelogindagger.HomeActivity
import com.dicoding.mysimplelogindagger.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: HomeActivity)
}