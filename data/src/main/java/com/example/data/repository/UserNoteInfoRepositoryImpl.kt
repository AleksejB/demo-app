package com.example.data.repository

import com.example.data.daos.UserNoteInfoLocalDataSource
import com.example.data.dto.UserNoteInfoDto
import com.example.domain.mapping.Mapper
import com.example.domain.model.UserNoteInfo
import com.example.domain.repository.UserNoteInfoRepository
import javax.inject.Inject

class UserNoteInfoRepositoryImpl @Inject constructor(
    private val userNoteInfoLocalDataSource: UserNoteInfoLocalDataSource,
    private val userNoteInfoMapper: Mapper<UserNoteInfoDto, UserNoteInfo>
): UserNoteInfoRepository {

    override suspend fun getUserNoteInfo(email: String): UserNoteInfo {
        return userNoteInfoLocalDataSource.getUserNoteInfo(email).let {
            userNoteInfoMapper.map(it)
        }
    }
}