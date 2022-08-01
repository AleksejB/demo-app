package com.example.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.data.dto.UserNoteInfoDto

@Dao
interface UserNoteInfoLocalDataSource {
    @Query("SELECT user.email, counter.count, note.text FROM user JOIN note ON Note.email = user.email JOIN counter ON counter.email = user.email WHERE user.email == :email")
    suspend fun getUserNoteInfo(email: String): UserNoteInfoDto
}