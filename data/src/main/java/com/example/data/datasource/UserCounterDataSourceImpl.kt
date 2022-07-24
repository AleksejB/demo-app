package com.example.data.datasource

import com.example.data.daos.UserCounterDao
import com.example.data.dto.UserCounterDto
import com.example.domain.datasource.UserCounterDataSource
import com.example.domain.mapping.Mapper
import com.example.domain.model.UserCounter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserCounterDataSourceImpl @Inject constructor(
    private val userCounterDao: UserCounterDao,
    private val userCounterMapper: Mapper<UserCounterDto, UserCounter>
): UserCounterDataSource {

    override suspend fun getUserAndCount(email: String): UserCounter {
        return userCounterMapper.map(userCounterDao.getUserFirstNameAndCount(email))
    }
}