package com.example.ui.seenotes

import androidx.lifecycle.viewModelScope
import com.example.base_ui.viewmodel.MVIViewModel
import com.example.domain.CurrentUser
import com.example.domain.model.UserNote
import com.example.domain.repository.NoteRepository
import com.example.domain.repository.UserNoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeeNotesViewModel @Inject constructor(
    private val userNoteRepository: UserNoteRepository
): MVIViewModel<SeeNotesState, SeeNotesEvent, SeeNotesEffect>() {

    private val _state : MutableStateFlow<SeeNotesState> = MutableStateFlow(SeeNotesState.Default)
    override val state: StateFlow<SeeNotesState>
        get() = _state

    fun onStart() {
        viewModelScope.launch {
            val listOfNotes = userNoteRepository.getAllNotesAndUserName()
            updateNotesInState(listOfNotes)
        }
    }

    override fun handleEvent(event: SeeNotesEvent) {
        when (event) {
            is SeeNotesEvent.NoteItemClicked -> {
                postEffect(SeeNotesEffect.NavigateToUserNoteInfo(event.email))
            }
        }
    }

    private fun updateNotesInState(notes: List<UserNote>) {
        _state.value = state.value.copy(
            notes = notes
        )
    }

}