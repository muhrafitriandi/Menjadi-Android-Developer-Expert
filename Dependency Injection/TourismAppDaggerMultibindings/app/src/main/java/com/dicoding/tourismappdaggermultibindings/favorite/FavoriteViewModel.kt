package com.dicoding.tourismappdaggermultibindings.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.tourismappdaggermultibindings.core.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val favoriteTourism = tourismUseCase.getFavoriteTourism().asLiveData()

}

