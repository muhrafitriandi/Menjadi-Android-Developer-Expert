package com.dicoding.tourismappdaggerhilt.di

import com.dicoding.tourismappdaggerhilt.core.di.CoreComponent
import com.dicoding.tourismappdaggerhilt.detail.DetailTourismActivity
import com.dicoding.tourismappdaggerhilt.favorite.FavoriteFragment
import com.dicoding.tourismappdaggerhilt.home.HomeFragment
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(activity: DetailTourismActivity)
}