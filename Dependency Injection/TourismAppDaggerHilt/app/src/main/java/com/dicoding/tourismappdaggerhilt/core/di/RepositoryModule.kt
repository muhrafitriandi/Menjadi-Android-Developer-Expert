package com.dicoding.tourismappdaggerhilt.core.di

import com.dicoding.tourismappdaggerhilt.core.data.TourismRepository
import com.dicoding.tourismappdaggerhilt.core.domain.repository.ITourismRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(tourismRepository: TourismRepository): ITourismRepository

}