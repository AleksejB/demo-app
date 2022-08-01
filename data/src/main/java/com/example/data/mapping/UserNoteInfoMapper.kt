package com.example.data.mapping

import com.example.data.dto.UserNoteInfoDto
import com.example.domain.mapping.Mapper
import com.example.domain.model.UserNoteInfo
import javax.inject.Inject

class UserNoteInfoMapper @Inject constructor(): Mapper<UserNoteInfoDto, UserNoteInfo> {
    override fun map(input: UserNoteInfoDto): UserNoteInfo {
        return UserNoteInfo(
            userEmail = input.email,
            userCount = input.count,
            userNote = input.noteText
        )
    }
}