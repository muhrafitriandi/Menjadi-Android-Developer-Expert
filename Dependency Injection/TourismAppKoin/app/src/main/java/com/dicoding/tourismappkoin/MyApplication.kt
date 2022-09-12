package com.dicoding.tourismappkoin

import android.app.Application
import com.dicoding.tourismappkoin.core.di.databaseModule
import com.dicoding.tourismappkoin.core.di.networkModule
import com.dicoding.tourismappkoin.core.di.repositoryModule
import com.dicoding.tourismappkoin.di.useCaseModule
import com.dicoding.tourismappkoin.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}