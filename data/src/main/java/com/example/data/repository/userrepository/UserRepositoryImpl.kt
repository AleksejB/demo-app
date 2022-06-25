package com.example.data.repository.userrepository

import com.example.data.datasource.userdatasource.UserDataSource
import com.example.demoappv1.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
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