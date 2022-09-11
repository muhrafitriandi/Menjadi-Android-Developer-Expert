package com.dicoding.tourismappretrofit.core.di

import android.content.Context

import com.dicoding.tourismappretrofit.core.data.source.local.LocalDataSource
import com.dicoding.tourismappretrofit.core.data.source.local.room.TourismDatabase

import com.dicoding.tourismappretrofit.core.data.TourismRepository
import com.dicoding.tourismappretrofit.core.data.source.remote.RemoteDataSource
import com.dicoding.tourismappretrofit.core.domain.repository.ITourismRepository
import com.dicoding.tourismappretrofit.core.domain.usecase.TourismInteractor
import com.dicoding.tourismappretrofit.core.domain.usecase.TourismUseCase
import com.dicoding.tourismappretrofit.core.utils.AppExecutors
import com.dicoding.tourismappretrofit.core.utils.JsonHelper

object Injection {
    private fun provideRepository(context: Context): ITourismRepository {
        val database = TourismDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideTourismUseCase(context: Context): TourismUseCase {
        val repository = provideRepository(context)
        return TourismInteractor(repository)
    }
}
