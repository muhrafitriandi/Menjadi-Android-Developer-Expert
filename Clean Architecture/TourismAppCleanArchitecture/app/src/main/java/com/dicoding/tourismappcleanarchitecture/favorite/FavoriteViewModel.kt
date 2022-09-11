package com.dicoding.tourismappcleanarchitecture.favorite

import androidx.lifecycle.ViewModel
import com.dicoding.tourismappcleanarchitecture.core.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val favoriteTourism = tourismUseCase.getFavoriteTourism()

}

