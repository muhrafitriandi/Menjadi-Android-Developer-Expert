package com.dicoding.tourismappcleanarchitecture.core.domain.repository

import androidx.lifecycle.LiveData
import com.dicoding.tourismappcleanarchitecture.core.data.Resource
import com.dicoding.tourismappcleanarchitecture.core.domain.model.Tourism

interface ITourismRepository {
    fun getAllTourism(): LiveData<Resource<List<Tourism>>>

    fun getFavoriteTourism(): LiveData<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}