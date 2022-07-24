package com.example.data.datasource

import android.util.Log
import com.example.data.daos.UserDao
import com.example.data.dto.UserDto
import com.example.domain.datasource.UserDataSource
import com.example.domain.mapping.Mapper
import com.example.domain.model.User
import javax.inject.Inject


class UserDataSourceImpl @Inject constructor(
    private val userDao: UserDao,
    private val userMapper: Mapper<UserDto, User>
): UserDataSource {

    companion object {
        private const val TAG = "UserDataSourceImpl"
    }

    override suspend fun getUserByEmail(email: String): Result<Unit> {
        val userDto = userDao.getUser(email)
        return if (userDto == null) {
            val exception = Exception("User does not exist")
            Result.failure(exception)
        } else {
            Result.success(Unit)
        }
    }

    override suspend fun insertNewUser(email: String, firstName: String) {
        return userDao.insertNewUser(
            UserDto(email, firstName)
        )
    }
}