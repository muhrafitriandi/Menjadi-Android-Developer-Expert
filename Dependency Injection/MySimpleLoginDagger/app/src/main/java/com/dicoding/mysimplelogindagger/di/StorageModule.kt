package com.dicoding.mysimplelogindagger.di

import android.content.Context
import com.dicoding.mysimplelogindagger.SessionManager
import dagger.Module
import dagger.Provides

@Module
class StorageModule {
    @Provides
    fun provideSessionManager(context: Context): SessionManager = SessionManager(context)
}