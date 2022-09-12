package com.dicoding.tourismappcoroutineflow.home

import androidx.lifecycle.ViewModel
import com.dicoding.tourismappcoroutineflow.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val tourism = tourismUseCase.getAllTourism()

}

