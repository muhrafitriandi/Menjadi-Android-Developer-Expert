package com.dicoding.tourismappdaggermultibindings.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.tourismappdaggermultibindings.core.domain.usecase.TourismUseCase
import com.dicoding.tourismappdaggermultibindings.detail.DetailTourismViewModel
import com.dicoding.tourismappdaggermultibindings.di.AppScope
import com.dicoding.tourismappdaggermultibindings.favorite.FavoriteViewModel
import com.dicoding.tourismappdaggermultibindings.home.HomeViewModel
import javax.inject.Inject
import javax.inject.Provider

@AppScope
class ViewModelFactory @Inject constructor(private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: creators.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        return creator.get() as T
    }
}