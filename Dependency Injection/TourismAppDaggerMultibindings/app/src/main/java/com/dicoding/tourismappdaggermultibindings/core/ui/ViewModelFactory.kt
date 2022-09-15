package com.dicoding.tourismappdaggermultibindings.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.tourismappdaggermultibindings.core.domain.usecase.TourismUseCase
import com.dicoding.tourismappdaggermultibindings.detail.DetailTourismViewModel
import com.dicoding.tourismappdaggermultibindings.di.AppScope
import com.dicoding.tourismappdaggermultibindings.favorite.FavoriteViewModel
import com.dicoding.tourismappdaggermultibindings.home.HomeViewModel
import javax.inject.Inject

@AppScope
class ViewModelFactory @Inject constructor(private val tourismUseCase: TourismUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(tourismUseCase) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(tourismUseCase) as T
            }
            modelClass.isAssignableFrom(DetailTourismViewModel::class.java) -> {
                DetailTourismViewModel(tourismUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}