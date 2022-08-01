package com.example.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.example.data.dto.UserNoteDto

@Dao
interface UserNoteLocalDataSource {

    @Query("SELECT user.email, text FROM user JOIN note ON user.email = note.email")
    suspend fun getAllNotesAndName(): List<UserNoteDto>?
}