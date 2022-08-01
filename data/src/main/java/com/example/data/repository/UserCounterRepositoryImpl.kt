package com.example.data.repository

import com.example.data.daos.UserCounterLocalDataSource
import com.example.data.dto.UserCounterDto
import com.example.domain.repository.UserCounterRepository
import com.example.domain.mapping.Mapper
import com.example.domain.model.UserCounter
import javax.inject.Inject

class UserCounterRepositoryImpl @Inject constructor(
    private val userCounterLocalDataSource: UserCounterLocalDataSource,
    private val userCounterMapper: Mapper<UserCounterDto, UserCounter>
): UserCounterRepository {

    override suspend fun getUserNameAndCount(email: String): UserCounter? {
        val userCounterDto = userCounterLocalDataSource.getUserFirstNameAndCount(email)
        return if (userCounterDto == null) {
            null
        } else {
            userCounterMapper.map(userCounterDto)
        }
    }
}