package com.example.demoappv1.repository

import com.example.demoappv1.User
import com.example.demoappv1.data.UserDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CounterRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
): CounterRepository {

    override fun getUserByUserName(userName: String): Flow<User?> {
        return userDataSource.getUserByUsername(userName)
    }

    override suspend fun updateUserCountByUsername(newCount: Int, userName: String) {
        return userDataSource.updateUserCountByUsername(newCount, userName)
    }

    override suspend fun insertNewUser(userName: String) {
        return userDataSource.insertNewUser(userName)
    }

}