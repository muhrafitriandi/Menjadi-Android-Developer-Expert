package com.dicoding.tourismappdaggermultibindings

import android.app.Application
import com.dicoding.tourismappdaggermultibindings.core.di.CoreComponent
import com.dicoding.tourismappdaggermultibindings.core.di.DaggerCoreComponent
import com.dicoding.tourismappdaggermultibindings.di.AppComponent
import com.dicoding.tourismappdaggermultibindings.di.DaggerAppComponent

open class MyApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}