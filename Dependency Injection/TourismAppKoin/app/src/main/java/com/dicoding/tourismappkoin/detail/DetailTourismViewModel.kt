package com.dicoding.tourismappkoin.detail

import androidx.lifecycle.ViewModel
import com.dicoding.tourismappkoin.core.domain.model.Tourism
import com.dicoding.tourismappkoin.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(private val tourismUseCase: TourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) = tourismUseCase.setFavoriteTourism(tourism, newStatus)
}

