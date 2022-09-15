package com.dicoding.tourismappdaggerhilt

import android.app.Application
import com.dicoding.tourismappdaggerhilt.core.di.CoreComponent
import com.dicoding.tourismappdaggerhilt.core.di.DaggerCoreComponent
import com.dicoding.tourismappdaggerhilt.di.AppComponent
import com.dicoding.tourismappdaggerhilt.di.DaggerAppComponent
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class MyApplication : Application() {
}