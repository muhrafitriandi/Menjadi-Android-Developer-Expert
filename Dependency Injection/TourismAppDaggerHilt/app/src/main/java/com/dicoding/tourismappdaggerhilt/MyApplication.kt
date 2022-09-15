package com.dicoding.tourismappdaggerhilt

import android.app.Application
import com.dicoding.tourismappdaggerhilt.core.di.CoreComponent
import com.dicoding.tourismappdaggerhilt.core.di.DaggerCoreComponent
import com.dicoding.tourismappdaggerhilt.di.AppComponent
import com.dicoding.tourismappdaggerhilt.di.DaggerAppComponent

open class MyApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}