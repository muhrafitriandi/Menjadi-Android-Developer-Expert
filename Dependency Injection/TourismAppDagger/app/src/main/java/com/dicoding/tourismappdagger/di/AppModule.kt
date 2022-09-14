package com.dicoding.tourismappdagger.di

import com.dicoding.tourismappdagger.core.domain.usecase.TourismInteractor
import com.dicoding.tourismappdagger.core.domain.usecase.TourismUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideTourismUseCase(tourismInteractor: TourismInteractor): TourismUseCase

}