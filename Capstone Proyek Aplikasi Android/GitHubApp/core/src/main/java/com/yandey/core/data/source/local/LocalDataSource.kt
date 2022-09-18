package com.yandey.core.data.source.local

import com.yandey.core.data.source.local.entity.UserEntity
import com.yandey.core.data.source.local.room.UserDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val userDao: UserDao) {
    suspend fun insertUser(userEntity: UserEntity) =
        userDao.insert(userEntity)

    fun getAllFavoriteUser(): Flow<List<UserEntity>> =
        userDao.getAllFavorite()

    suspend fun deleteUser(userEntity: UserEntity) =
        userDao.delete(userEntity)

    fun getFavoriteStateUser(username: String): Flow<UserEntity> =
        userDao.getFavoriteState(username)
}