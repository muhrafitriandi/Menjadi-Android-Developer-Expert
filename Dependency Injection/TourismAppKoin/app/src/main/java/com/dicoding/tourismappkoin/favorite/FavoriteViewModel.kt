package com.dicoding.tourismappkoin.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.tourismappkoin.core.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val favoriteTourism = tourismUseCase.getFavoriteTourism().asLiveData()

}

