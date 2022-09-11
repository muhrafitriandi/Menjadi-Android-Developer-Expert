package com.dicoding.tourismappcleanarchitecture.core.di

import android.content.Context

import com.dicoding.tourismappcleanarchitecture.core.data.source.local.LocalDataSource
import com.dicoding.tourismappcleanarchitecture.core.data.source.local.room.TourismDatabase

import com.dicoding.tourismappcleanarchitecture.core.data.TourismRepository
import com.dicoding.tourismappcleanarchitecture.core.data.source.remote.RemoteDataSource
import com.dicoding.tourismappcleanarchitecture.core.domain.repository.ITourismRepository
import com.dicoding.tourismappcleanarchitecture.core.domain.usecase.TourismInteractor
import com.dicoding.tourismappcleanarchitecture.core.domain.usecase.TourismUseCase
import com.dicoding.tourismappcleanarchitecture.core.utils.AppExecutors
import com.dicoding.tourismappcleanarchitecture.core.utils.JsonHelper

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
