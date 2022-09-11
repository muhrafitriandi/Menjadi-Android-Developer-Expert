package com.dicoding.tourismappcleanarchitecture.detail

import androidx.lifecycle.ViewModel
import com.dicoding.tourismappcleanarchitecture.core.domain.model.Tourism
import com.dicoding.tourismappcleanarchitecture.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(private val tourismUseCase: TourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) = tourismUseCase.setFavoriteTourism(tourism, newStatus)
}

