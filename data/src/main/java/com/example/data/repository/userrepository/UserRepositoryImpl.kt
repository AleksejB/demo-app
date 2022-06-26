package com.example.data.repository.userrepository

import com.example.data.datasource.userdatasource.UserDataSource
import com.example.demoappv1.User
import javax.inject.Inject
import kotlin.Exception

internal class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
): UserRepository {

//    override suspend fun getUserById(userId: String): User? {
//        return userDataSource.getUserById(userId)
//    }

    override suspend fun doesUserExist(firstName: String, lastName: String): Result<User?> {
        val user = userDataSource.getUserByFirstAndLastName(firstName = firstName, lastName = lastName)
        return if (user == null) {
            val e = Exception("User does not exist")
            Result.failure(e)
        } else {
            Result.success(user)
        }

    }

    override suspend fun insertUser(userId: String, firstName: String, lastName: String): Result<Unit> {
        return kotlin.runCatching {
            userDataSource.insertNewUser(
                userId = userId,
                firstName = firstName,
                lastName = lastName
            )
        }.onSuccess {
            Result.success(Unit)
        }.onFailure {
            Result.failure<Unit>(it)
        }
    }

    override suspend fun updateUser(userId: String, firstName: String, lastName: String) {
        return userDataSource.updateUser(
            userId = userId,
            firstName = firstName,
            lastName = lastName
        )
    }
}