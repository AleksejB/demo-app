package com.example.data.mapping

import com.example.data.dto.UserCounterDto
import com.example.domain.mapping.Mapper
import com.example.domain.model.UserCounter
import javax.inject.Inject

class UserCounterMapper @Inject constructor(): Mapper<UserCounterDto, UserCounter> {

    override fun map(input: UserCounterDto): UserCounter {
        return UserCounter(
            firstName = input.firstName,
            count = input.count
        )
    }
}