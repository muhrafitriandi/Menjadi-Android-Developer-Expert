package com.dicoding.tourismappdaggermultibindings.core.di

import com.dicoding.tourismappdaggermultibindings.core.data.TourismRepository
import com.dicoding.tourismappdaggermultibindings.core.domain.repository.ITourismRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(tourismRepository: TourismRepository): ITourismRepository

}