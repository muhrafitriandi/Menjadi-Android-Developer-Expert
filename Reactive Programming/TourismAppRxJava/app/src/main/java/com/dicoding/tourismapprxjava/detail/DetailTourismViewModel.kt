package com.dicoding.tourismapprxjava.detail

import androidx.lifecycle.ViewModel
import com.dicoding.tourismapprxjava.core.domain.model.Tourism
import com.dicoding.tourismapprxjava.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(private val tourismUseCase: TourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) = tourismUseCase.setFavoriteTourism(tourism, newStatus)
}

