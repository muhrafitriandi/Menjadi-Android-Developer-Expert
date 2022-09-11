package com.dicoding.tourismappretrofit.detail

import androidx.lifecycle.ViewModel
import com.dicoding.tourismappretrofit.core.domain.model.Tourism
import com.dicoding.tourismappretrofit.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(private val tourismUseCase: TourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) = tourismUseCase.setFavoriteTourism(tourism, newStatus)
}

