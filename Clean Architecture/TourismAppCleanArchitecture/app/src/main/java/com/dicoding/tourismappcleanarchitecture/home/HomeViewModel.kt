package com.dicoding.tourismappcleanarchitecture.home

import androidx.lifecycle.ViewModel
import com.dicoding.tourismappcleanarchitecture.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val tourism = tourismUseCase.getAllTourism()

}

