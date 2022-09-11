package com.dicoding.tourismapprxjava.core.domain.repository

import com.dicoding.tourismapprxjava.core.data.Resource
import com.dicoding.tourismapprxjava.core.domain.model.Tourism
import io.reactivex.Flowable

interface ITourismRepository {
    fun getAllTourism(): Flowable<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flowable<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}