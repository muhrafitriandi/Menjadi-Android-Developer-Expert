package com.dicoding.tourismappdaggermultibindings.core.domain.repository

import com.dicoding.tourismappdaggermultibindings.core.data.Resource
import com.dicoding.tourismappdaggermultibindings.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface ITourismRepository {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flow<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}