package com.example.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class UserDto(
    @PrimaryKey val email: String,
    val firstName: String
)