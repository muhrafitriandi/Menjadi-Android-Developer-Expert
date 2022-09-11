package com.dicoding.tourismapprxjava.core.domain.usecase

import androidx.lifecycle.LiveData
import com.dicoding.tourismapprxjava.core.data.Resource
import com.dicoding.tourismapprxjava.core.domain.model.Tourism

interface TourismUseCase {
    fun getAllTourism(): LiveData<Resource<List<Tourism>>>
    fun getFavoriteTourism(): LiveData<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}