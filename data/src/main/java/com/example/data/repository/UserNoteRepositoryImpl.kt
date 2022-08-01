package com.example.data.repository

import com.example.data.daos.UserNoteLocalDataSource
import com.example.data.dto.UserNoteDto
import com.example.domain.mapping.Mapper
import com.example.domain.model.UserNote
import com.example.domain.repository.UserNoteRepository
import javax.inject.Inject

class UserNoteRepositoryImpl @Inject constructor(
    private val userNoteLocalDataSource: UserNoteLocalDataSource,
    private val userNoteMapper: Mapper<UserNoteDto, UserNote>
): UserNoteRepository {
    override suspend fun getAllNotesAndUserName(): List<UserNote> {
        val userNoteDto = userNoteLocalDataSource.getAllNotesAndName()
        return userNoteDto?.map { userNoteDto ->
            userNoteMapper.map(userNoteDto)
        } ?: emptyList()
    }
}