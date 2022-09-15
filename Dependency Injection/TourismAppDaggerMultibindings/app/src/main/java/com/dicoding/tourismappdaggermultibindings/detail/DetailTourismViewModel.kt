package com.dicoding.tourismappdaggermultibindings.detail

import androidx.lifecycle.ViewModel
import com.dicoding.tourismappdaggermultibindings.core.domain.model.Tourism
import com.dicoding.tourismappdaggermultibindings.core.domain.usecase.TourismUseCase
import javax.inject.Inject

class DetailTourismViewModel @Inject constructor(private val tourismUseCase: TourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) = tourismUseCase.setFavoriteTourism(tourism, newStatus)
}

