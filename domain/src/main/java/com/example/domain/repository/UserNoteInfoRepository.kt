package com.example.domain.repository

import com.example.domain.model.UserNoteInfo

interface UserNoteInfoRepository {
    suspend fun getUserNoteInfo(email: String): UserNoteInfo
}