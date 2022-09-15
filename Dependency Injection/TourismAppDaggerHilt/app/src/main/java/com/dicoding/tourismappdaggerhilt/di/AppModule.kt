package com.dicoding.tourismappdaggerhilt.di

import com.dicoding.tourismappdaggerhilt.core.domain.usecase.TourismInteractor
import com.dicoding.tourismappdaggerhilt.core.domain.usecase.TourismUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideTourismUseCase(tourismInteractor: TourismInteractor): TourismUseCase

}