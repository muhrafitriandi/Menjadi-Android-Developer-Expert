package com.dicoding.tourismappcoroutineflow.favorite

import androidx.lifecycle.ViewModel
import com.dicoding.tourismappcoroutineflow.core.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val favoriteTourism = tourismUseCase.getFavoriteTourism()

}

