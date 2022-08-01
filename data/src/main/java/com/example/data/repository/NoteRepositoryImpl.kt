package com.example.data.repository

import com.example.data.daos.NoteLocalDataSource
import com.example.data.dto.NoteDto
import com.example.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteLocalDataSource: NoteLocalDataSource
): NoteRepository {

    override suspend fun saveNote(email: String, noteText: String) {
        return noteLocalDataSource.saveNote(
            NoteDto(
                email = email,
                text = noteText
            )
        )
    }
}