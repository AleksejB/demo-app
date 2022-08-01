package com.example.ui.seenotes

import com.example.domain.model.UserNote

data class SeeNotesState(
    val notes: List<UserNote>
) {
    companion object {
        val Default = SeeNotesState(
            notes = emptyList()
        )
    }
}