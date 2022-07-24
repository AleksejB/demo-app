package com.example.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.daos.CounterDao
import com.example.data.daos.UserCounterDao
import com.example.data.daos.UserDao
import com.example.data.dto.CounterDto
import com.example.data.dto.UserDto

@Database(entities = [UserDto::class, CounterDto::class], version = 1)
abstract class DemoAppDatabase: RoomDatabase() {

    abstract fun getUserDao(): UserDao
    abstract fun getCounterDao(): CounterDao
    abstract fun getUserCounterDao(): UserCounterDao
}