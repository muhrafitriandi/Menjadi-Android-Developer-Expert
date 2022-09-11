package com.dicoding.tourismapprxjava.home

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.dicoding.tourismapprxjava.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val tourism = LiveDataReactiveStreams.fromPublisher(tourismUseCase.getAllTourism())

}

