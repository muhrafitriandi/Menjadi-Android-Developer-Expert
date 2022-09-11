package com.dicoding.tourismapprxjava.core.data.source.remote.network

import com.dicoding.tourismapprxjava.core.data.source.remote.response.ListTourismResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("list")
    fun getList(): Call<ListTourismResponse>
}