package com.example.data.dto

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(foreignKeys = [
    ForeignKey(
        entity = UserDto::class,
        parentColumns = ["email"],
        childColumns = ["email"],
        onDelete = ForeignKey.CASCADE
    )
], tableName = "Counter")
data class CounterDto(
    @PrimaryKey val email: String,
    val count: Int
)
