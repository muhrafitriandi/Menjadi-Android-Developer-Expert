package com.dicoding.tourismappcoroutineflow.core.domain.usecase

import androidx.lifecycle.LiveData
import com.dicoding.tourismappcoroutineflow.core.data.Resource
import com.dicoding.tourismappcoroutineflow.core.domain.model.Tourism

interface TourismUseCase {
    fun getAllTourism(): LiveData<Resource<List<Tourism>>>
    fun getFavoriteTourism(): LiveData<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}