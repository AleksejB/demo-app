package com.example.ui.writenotes

sealed interface WriteNotesEvent {
    data class NoteTextValueChanged(val input: String): WriteNotesEvent
    object SaveClicked: WriteNotesEvent
}