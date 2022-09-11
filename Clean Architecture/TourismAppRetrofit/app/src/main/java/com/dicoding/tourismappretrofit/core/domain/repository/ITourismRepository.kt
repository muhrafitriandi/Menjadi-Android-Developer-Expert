package com.dicoding.tourismappretrofit.core.domain.repository

import androidx.lifecycle.LiveData
import com.dicoding.tourismappretrofit.core.data.Resource
import com.dicoding.tourismappretrofit.core.domain.model.Tourism

interface ITourismRepository {
    fun getAllTourism(): LiveData<Resource<List<Tourism>>>

    fun getFavoriteTourism(): LiveData<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}