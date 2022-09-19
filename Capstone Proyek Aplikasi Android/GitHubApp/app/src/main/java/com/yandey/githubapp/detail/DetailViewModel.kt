package com.yandey.githubapp.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.yandey.core.domain.model.User
import com.yandey.core.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val userUseCase: UserUseCase
) : ViewModel() {
    fun getDetailUser(
        username: String
    ) = userUseCase.getDetailUser(username).asLiveData()

    fun getFavoriteStateUser(
        username: String
    ) = userUseCase.getFavoriteStateUser(username).asLiveData()

    fun insertUser(
        user: User
    ) = viewModelScope.launch {
            userUseCase.insertUser(user)
        }

    fun deleteUser(
        user: User
    ) = viewModelScope.launch {
            userUseCase.deleteUser(user)
        }
}