package com.dicoding.tourismappdaggermultibindings.core.domain.usecase

import com.dicoding.tourismappdaggermultibindings.core.data.Resource
import com.dicoding.tourismappdaggermultibindings.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface TourismUseCase {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>
    fun getFavoriteTourism(): Flow<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}