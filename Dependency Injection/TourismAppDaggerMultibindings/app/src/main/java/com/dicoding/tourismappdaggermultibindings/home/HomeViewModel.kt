package com.dicoding.tourismappdaggermultibindings.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.tourismappdaggermultibindings.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val tourism = tourismUseCase.getAllTourism().asLiveData()

}

