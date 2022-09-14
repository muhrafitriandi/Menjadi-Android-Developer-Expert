package com.dicoding.tourismappdagger

import android.app.Application
import com.dicoding.tourismappdagger.core.di.CoreComponent
import com.dicoding.tourismappdagger.core.di.DaggerCoreComponent
import com.dicoding.tourismappdagger.di.AppComponent
import com.dicoding.tourismappdagger.di.DaggerAppComponent

open class MyApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}