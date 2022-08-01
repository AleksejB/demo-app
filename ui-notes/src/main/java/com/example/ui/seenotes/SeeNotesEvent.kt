package com.example.ui.seenotes

sealed interface SeeNotesEvent {
    data class NoteItemClicked(val email: String): SeeNotesEvent
}