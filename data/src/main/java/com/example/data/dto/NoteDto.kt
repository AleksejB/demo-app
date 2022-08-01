package com.example.data.dto

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Note",
    foreignKeys = [
        ForeignKey(
            entity = UserDto::class,
            parentColumns = ["email"],
            childColumns = ["email"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class NoteDto(
    @PrimaryKey val email: String,
    val text: String
)