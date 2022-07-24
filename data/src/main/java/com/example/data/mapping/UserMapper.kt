package com.example.data.mapping

import com.example.data.dto.UserDto
import com.example.domain.mapping.Mapper
import com.example.domain.model.User
import javax.inject.Inject

class UserMapper @Inject constructor(): Mapper<UserDto, User> {

    override fun map(input: UserDto): User {
        return User(
            email = input.email,
            firstName = input.firstName
        )
    }
}