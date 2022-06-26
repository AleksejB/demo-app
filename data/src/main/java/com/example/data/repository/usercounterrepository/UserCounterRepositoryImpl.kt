package com.example.data.repository.usercounterrepository

import com.example.data.datasource.usercounterdatasource.UserCounterDataSource
import com.example.demoappv1.GetUserAndCount
import com.example.demoappv1.UserDatabase
import com.example.domain.model.UserCounter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserCounterRepositoryImpl @Inject constructor(
    private val userCounterDataSource: UserCounterDataSource
): UserCounterRepository {

    override fun getUserCounter(userId: String): Flow<List<GetUserAndCount?>> {
        return userCounterDataSource.getUserAndCount(userId)
    }
}