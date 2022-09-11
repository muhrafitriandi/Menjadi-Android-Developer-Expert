package com.dicoding.tourismappretrofit.home

import androidx.lifecycle.ViewModel
import com.dicoding.tourismappretrofit.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val tourism = tourismUseCase.getAllTourism()

}

