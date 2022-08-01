package com.example.domain.repository

interface NoteRepository {
    suspend fun saveNote(email: String, noteText: String)
}