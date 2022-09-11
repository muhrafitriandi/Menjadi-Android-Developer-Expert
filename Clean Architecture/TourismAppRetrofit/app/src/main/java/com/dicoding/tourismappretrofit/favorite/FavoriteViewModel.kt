package com.dicoding.tourismappretrofit.favorite

import androidx.lifecycle.ViewModel
import com.dicoding.tourismappretrofit.core.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val favoriteTourism = tourismUseCase.getFavoriteTourism()

}

