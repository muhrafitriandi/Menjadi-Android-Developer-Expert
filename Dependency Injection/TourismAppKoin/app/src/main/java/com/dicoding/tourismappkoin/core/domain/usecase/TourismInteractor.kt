package com.dicoding.tourismappkoin.core.domain.usecase

import com.dicoding.tourismappkoin.core.domain.model.Tourism
import com.dicoding.tourismappkoin.core.domain.repository.ITourismRepository

class TourismInteractor(private val tourismRepository: ITourismRepository): TourismUseCase {

    override fun getAllTourism() = tourismRepository.getAllTourism()

    override fun getFavoriteTourism() = tourismRepository.getFavoriteTourism()

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) = tourismRepository.setFavoriteTourism(tourism, state)

}