package com.example.ui.stats.notestats

data class UserNoteInfoState(
    val email: String,
    val noteText: String,
    val count: Int
) {
    companion object {
        val Default = UserNoteInfoState(
            email = "",
            noteText = "",
            count = -999
        )
    }
}