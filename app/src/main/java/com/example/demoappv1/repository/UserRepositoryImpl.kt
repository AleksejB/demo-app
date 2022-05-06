package com.example.demoappv1.repository

import com.example.demoappv1.User
import com.example.demoappv1.data.UserDataSource
import com.example.demoappv1.ui.models.counter.CounterState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
): UserRepository {

    override fun getUserByUserNameAsFlow(userName: String): Flow<User?> {
        return userDataSource.getUserByUsernameAsFlow(userName)
    }

    override suspend fun getUserByUsername(userName: String): User? {
        return userDataSource.getUserByUsername(userName)
    }

    override suspend fun updateUserCountByUsername(newCount: Int, userName: String) {
        return userDataSource.updateUserCountByUsername(newCount, userName)
    }

    override suspend fun insertNewUser(userName: String) {
        return userDataSource.insertNewUser(userName)
    }

}