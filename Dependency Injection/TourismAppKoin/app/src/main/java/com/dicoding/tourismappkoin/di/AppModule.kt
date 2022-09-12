package com.dicoding.tourismappkoin.di

import com.dicoding.tourismappkoin.core.domain.usecase.TourismInteractor
import com.dicoding.tourismappkoin.core.domain.usecase.TourismUseCase
import com.dicoding.tourismappkoin.detail.DetailTourismViewModel
import com.dicoding.tourismappkoin.favorite.FavoriteViewModel
import com.dicoding.tourismappkoin.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TourismUseCase> { TourismInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailTourismViewModel(get()) }
}