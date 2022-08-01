package com.example.domain.repository

import com.example.domain.model.UserNote

interface UserNoteRepository {
    suspend fun getAllNotesAndUserName(): List<UserNote>
}