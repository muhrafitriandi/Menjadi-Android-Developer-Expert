package com.dicoding.tourismapprxjava.favorite

import androidx.lifecycle.ViewModel
import com.dicoding.tourismapprxjava.core.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val favoriteTourism = tourismUseCase.getFavoriteTourism()

}

