package com.example.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.dto.NoteDto
import com.example.domain.model.Note

@Dao
interface NoteLocalDataSource {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveNote(noteDto: NoteDto)

    @Query("SELECT * FROM note")
    suspend fun getAllNotes(): List<Note>?
}