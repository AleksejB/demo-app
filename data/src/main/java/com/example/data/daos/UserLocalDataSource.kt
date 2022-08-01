package com.example.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.dto.UserDto

@Dao
interface UserLocalDataSource {

    @Insert
    suspend fun insertNewUser(userDto: UserDto)

    @Query("SELECT * FROM user WHERE email == :email")
    suspend fun getUser(email: String): UserDto?
}