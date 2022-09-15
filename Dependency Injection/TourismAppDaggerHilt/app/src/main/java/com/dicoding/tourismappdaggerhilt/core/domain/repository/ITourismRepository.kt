package com.dicoding.tourismappdaggerhilt.core.domain.repository

import com.dicoding.tourismappdaggerhilt.core.data.Resource
import com.dicoding.tourismappdaggerhilt.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface ITourismRepository {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flow<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}