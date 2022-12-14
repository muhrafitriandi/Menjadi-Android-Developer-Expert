package com.dicoding.tourismappcleanarchitecture.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.dicoding.tourismappcleanarchitecture.core.data.source.remote.network.ApiResponse
import com.dicoding.tourismappcleanarchitecture.core.data.source.local.LocalDataSource
import com.dicoding.tourismappcleanarchitecture.core.data.source.remote.RemoteDataSource
import com.dicoding.tourismappcleanarchitecture.core.data.source.remote.response.TourismResponse
import com.dicoding.tourismappcleanarchitecture.core.domain.model.Tourism
import com.dicoding.tourismappcleanarchitecture.core.domain.repository.ITourismRepository
import com.dicoding.tourismappcleanarchitecture.core.utils.AppExecutors
import com.dicoding.tourismappcleanarchitecture.core.utils.DataMapper

class TourismRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ITourismRepository {

    companion object {
        @Volatile
        private var instance: TourismRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): TourismRepository =
            instance ?: synchronized(this) {
                instance ?: TourismRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllTourism(): LiveData<Resource<List<Tourism>>> =
        object : NetworkBoundResource<List<Tourism>, List<TourismResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Tourism>> {
                return Transformations.map(localDataSource.getAllTourism()) { tourismEntity ->
                    DataMapper.mapEntitiesToDomain(tourismEntity)
                }
            }

            override fun shouldFetch(data: List<Tourism>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TourismResponse>>> =
                remoteDataSource.getAllTourism()

            override fun saveCallResult(data: List<TourismResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asLiveData()

    override fun getFavoriteTourism(): LiveData<List<Tourism>> {
        return Transformations.map(localDataSource.getFavoriteTourism()) { tourismEntity ->
            DataMapper.mapEntitiesToDomain(tourismEntity)
        }
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
    }
}

