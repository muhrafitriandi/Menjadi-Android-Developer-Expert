package com.dicoding.tourismappdaggermultibindings.di

import com.dicoding.tourismappdaggermultibindings.core.di.CoreComponent
import com.dicoding.tourismappdaggermultibindings.detail.DetailTourismActivity
import com.dicoding.tourismappdaggermultibindings.favorite.FavoriteFragment
import com.dicoding.tourismappdaggermultibindings.home.HomeFragment
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