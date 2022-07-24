package com.example.data.repository

import android.util.Log
import com.example.domain.repository.UserRepository
import com.example.domain.datasource.UserDataSource
import com.example.domain.model.User
import javax.inject.Inject
import kotlin.Exception

internal class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
): UserRepository {

    companion object {
        private const val TAG = "UserRepositoryImpl"
    }

    override suspend fun doesUserExist(email: String): Result<Unit> {
        val response = userDataSource.getUserByEmail(email)
        return response.fold(
            onSuccess = {
                Result.success(Unit)
            },
            onFailure = {
                Result.failure(it)
            }
        )
    }

    override suspend fun insertUser(email: String, firstName: String) {
        return userDataSource.insertNewUser(email, firstName)
    }
}