package com.example.data.mapping

import com.example.data.dto.UserNoteDto
import com.example.domain.mapping.Mapper
import com.example.domain.model.UserNote
import javax.inject.Inject

class UserNoteMapper @Inject constructor(): Mapper<UserNoteDto, UserNote> {
    override fun map(input: UserNoteDto): UserNote {
        return UserNote(
            email = input.userEmail,
            noteText = input.noteText
        )
    }
}