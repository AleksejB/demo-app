package com.example.ui.seenotes

sealed interface SeeNotesEffect {
    data class NavigateToUserNoteInfo(val email: String): SeeNotesEffect
}