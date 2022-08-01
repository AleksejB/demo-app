package com.example.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.dto.CounterDto
import com.example.data.dto.UserDto
import kotlinx.coroutines.flow.Flow

@Dao
interface CounterLocalDataSource {

//    @Query("INSERT INTO counter VALUES (:email, :count)")
//    suspend fun insertNewCount(email: String, count: Int)

    @Insert
    suspend fun insertNewCount(counterDto: CounterDto)

    @Query("SELECT count FROM counter WHERE email == :email")
    fun getUserCount(email: String): Flow<Int?>

    @Update
    suspend fun updateCount(counterDto: CounterDto)
}