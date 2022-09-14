package com.dicoding.mysimplelogindagger

import android.app.Application
import com.dicoding.mysimplelogindagger.di.AppComponent
import com.dicoding.mysimplelogindagger.di.DaggerAppComponent

open class MyApplication : Application(){
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(
            applicationContext
        )
    }
}