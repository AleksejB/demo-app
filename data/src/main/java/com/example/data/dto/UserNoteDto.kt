package com.example.data.dto

import androidx.room.ColumnInfo

data class UserNoteDto(
    @ColumnInfo(name = "email") val userEmail: String,
    @ColumnInfo(name = "text") val noteText: String
)
