package com.dicoding.tourismappdagger.detail

import androidx.lifecycle.ViewModel
import com.dicoding.tourismappdagger.core.domain.model.Tourism
import com.dicoding.tourismappdagger.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(private val tourismUseCase: TourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) = tourismUseCase.setFavoriteTourism(tourism, newStatus)
}

