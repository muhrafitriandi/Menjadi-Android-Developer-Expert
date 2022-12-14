package com.dicoding.tourismappdaggermultibindings.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.tourismappdaggermultibindings.core.ui.ViewModelFactory
import com.dicoding.tourismappdaggermultibindings.detail.DetailTourismViewModel
import com.dicoding.tourismappdaggermultibindings.favorite.FavoriteViewModel
import com.dicoding.tourismappdaggermultibindings.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    abstract fun bindFavoriteViewModel(viewModel: FavoriteViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailTourismViewModel::class)
    abstract fun bindDetailTourismViewModel(viewModel: DetailTourismViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}