package com.example.ui.writenotes

sealed interface WriteNotesEffect {
    object NavigateBack: WriteNotesEffect
}