package com.example.ui.writenotes

data class WriteNotesState(
    val currentNoteTextValue: String
) {
    companion object {
        val Default = WriteNotesState(
            currentNoteTextValue = ""
        )
    }
}