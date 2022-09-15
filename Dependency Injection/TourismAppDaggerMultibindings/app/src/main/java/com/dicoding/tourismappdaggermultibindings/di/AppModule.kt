package com.dicoding.tourismappdaggermultibindings.di

import com.dicoding.tourismappdaggermultibindings.core.domain.usecase.TourismInteractor
import com.dicoding.tourismappdaggermultibindings.core.domain.usecase.TourismUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideTourismUseCase(tourismInteractor: TourismInteractor): TourismUseCase

}