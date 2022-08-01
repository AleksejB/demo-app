package com.example.ui.writenotes

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.base_ui.viewmodel.MVIViewModel
import com.example.domain.CurrentUser
import com.example.domain.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WriteNotesViewModel @Inject constructor(
    private val noteRepository: NoteRepository
): MVIViewModel<WriteNotesState, WriteNotesEvent, WriteNotesEffect>() {

    private val _state: MutableStateFlow<WriteNotesState> = MutableStateFlow(WriteNotesState.Default)
    override val state: StateFlow<WriteNotesState>
        get() = _state

    init {
        Log.d("TAAAG", "current user: ${CurrentUser.currentUser}")//get empty strings here
    }

    override fun handleEvent(event: WriteNotesEvent) {
        when (event) {
            is WriteNotesEvent.SaveClicked -> {
                viewModelScope.launch {
                    noteRepository.saveNote(
                        email = CurrentUser.currentUser.email,
                        noteText = state.value.currentNoteTextValue
                    )
                }
                postEffect(WriteNotesEffect.NavigateBack)
            }
            is WriteNotesEvent.NoteTextValueChanged -> {
                updateCurrentNoteTextValueInState(event.input)
            }
        }
    }

    private fun updateCurrentNoteTextValueInState(input: String) {
        _state.value = state.value.copy(
            currentNoteTextValue = input
        )
    }

}