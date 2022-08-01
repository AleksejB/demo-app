package com.example.data.repository

import com.example.data.daos.UserLocalDataSource
import com.example.data.dto.UserDto
import com.example.domain.mapping.Mapper
import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource,
    private val userMapper: Mapper<UserDto, User>
): UserRepository {

    companion object {
        private const val TAG = "UserRepositoryImpl"
    }

    override suspend fun doesUserExist(email: String): Boolean {
        return userLocalDataSource.getUser(email) != null
    }

    override suspend fun insertUser(email: String, firstName: String) {
        return userLocalDataSource.insertNewUser(
            UserDto(
                email = email,
                firstName = firstName
            )
        )
    }
}