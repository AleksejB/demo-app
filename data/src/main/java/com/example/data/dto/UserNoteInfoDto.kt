package com.example.data.dto

import androidx.room.ColumnInfo

data class UserNoteInfoDto(
    val email: String,
    val count: Int,
    @ColumnInfo(name = "text") val noteText: String
)