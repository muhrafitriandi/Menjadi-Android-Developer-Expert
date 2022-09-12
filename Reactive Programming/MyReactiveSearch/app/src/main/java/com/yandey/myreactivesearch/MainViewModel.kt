package com.yandey.myreactivesearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.yandey.myreactivesearch.network.ApiConfig
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*

@FlowPreview
@ExperimentalCoroutinesApi
class MainViewModel: ViewModel() {

    private val accessToken = "pk.eyJ1IjoibXVocmFmaXRyaWFuZGkiLCJhIjoiY2w3eGNhcDZlMHR3ejN1bXM2NWpjZmtueSJ9.uHXSy904gs7k6DQBnC-ENA"
    val queryChannel = MutableStateFlow("")

    val searchResult = queryChannel
        .debounce(300)
        .distinctUntilChanged()
        .filter {
            it.trim().isNotEmpty()
        }
        .mapLatest {
            ApiConfig.provideApiService().getCountry(it, accessToken).features
        }
        .asLiveData()
}