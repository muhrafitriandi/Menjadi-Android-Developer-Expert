package com.dicoding.tourismappdagger.core.di

import com.dicoding.tourismappdagger.core.data.TourismRepository
import com.dicoding.tourismappdagger.core.domain.repository.ITourismRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(tourismRepository: TourismRepository): ITourismRepository

}