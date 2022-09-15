package com.dicoding.tourismappdaggerhilt.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.tourismappdaggerhilt.core.domain.usecase.TourismUseCase
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(tourismUseCase: TourismUseCase) : ViewModel() {

    val favoriteTourism = tourismUseCase.getFavoriteTourism().asLiveData()

}

