package com.example.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.data.dto.UserCounterDto
import com.example.domain.model.UserCounter
import kotlinx.coroutines.flow.Flow

@Dao
interface UserCounterLocalDataSource {

    @Query("SELECT firstName, count FROM user JOIN counter ON user.email = counter.email WHERE user.email == :email")
    suspend fun getUserFirstNameAndCount(email: String): UserCounterDto?
}