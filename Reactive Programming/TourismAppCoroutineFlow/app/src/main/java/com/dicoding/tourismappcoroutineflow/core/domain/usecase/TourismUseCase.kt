package com.dicoding.tourismappcoroutineflow.core.domain.usecase

import com.dicoding.tourismappcoroutineflow.core.data.Resource
import com.dicoding.tourismappcoroutineflow.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface TourismUseCase {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>
    fun getFavoriteTourism(): Flow<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}