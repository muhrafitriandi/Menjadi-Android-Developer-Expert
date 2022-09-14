package com.dicoding.tourismappdagger.di

import com.dicoding.tourismappdagger.core.di.CoreComponent
import com.dicoding.tourismappdagger.detail.DetailTourismActivity
import com.dicoding.tourismappdagger.favorite.FavoriteFragment
import com.dicoding.tourismappdagger.home.HomeFragment
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
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