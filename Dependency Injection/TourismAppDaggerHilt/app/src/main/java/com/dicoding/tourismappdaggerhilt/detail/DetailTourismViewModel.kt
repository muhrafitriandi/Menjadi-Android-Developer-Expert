package com.dicoding.tourismappdaggerhilt.detail

import androidx.lifecycle.ViewModel
import com.dicoding.tourismappdaggerhilt.core.domain.model.Tourism
import com.dicoding.tourismappdaggerhilt.core.domain.usecase.TourismUseCase
import javax.inject.Inject

class DetailTourismViewModel @Inject constructor(private val tourismUseCase: TourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) = tourismUseCase.setFavoriteTourism(tourism, newStatus)
}

