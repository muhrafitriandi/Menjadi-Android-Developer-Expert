package com.dicoding.tourismappkoin.core.domain.usecase

import com.dicoding.tourismappkoin.core.data.Resource
import com.dicoding.tourismappkoin.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface TourismUseCase {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>
    fun getFavoriteTourism(): Flow<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}