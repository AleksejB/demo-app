package com.example.data.repository

import com.example.domain.repository.UserCounterRepository
import com.example.domain.datasource.UserCounterDataSource
import com.example.domain.model.UserCounter
import javax.inject.Inject

class UserCounterRepositoryImpl @Inject constructor(
    private val userCounterDataSource: UserCounterDataSource
): UserCounterRepository {

    override suspend fun getUserNameANdCount(email: String): UserCounter {
        return userCounterDataSource.getUserAndCount(email)
    }
}