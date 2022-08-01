package com.example.ui.stats.notestats

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.base_ui.viewmodel.MVIViewModel
import com.example.domain.model.UserNoteInfo
import com.example.domain.repository.UserNoteInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserNoteInfoViewModel @Inject constructor(
    private val userNoteInfoRepository: UserNoteInfoRepository,
    savedStateHandle: SavedStateHandle
): MVIViewModel<UserNoteInfoState, UserNoteInfoEvent, UserNoteInfoEffect>()  {

    private val userEmail: String = savedStateHandle.get<String>("email")!!

    private val _state: MutableStateFlow<UserNoteInfoState> = MutableStateFlow(UserNoteInfoState.Default)
    override val state: StateFlow<UserNoteInfoState>
        get() = _state

    fun onStart() {
        viewModelScope.launch {
            val userNoteInfo = userNoteInfoRepository.getUserNoteInfo(userEmail)
            updateUserNoteInfoInState(userNoteInfo)
        }
    }

    override fun handleEvent(event: UserNoteInfoEvent) {
//        when (event) {
//
//        }
    }

    private fun updateUserNoteInfoInState(userNoteInfo: UserNoteInfo) {
        _state.value = state.value.copy(
            email = userNoteInfo.userEmail,
            count = userNoteInfo.userCount,
            noteText = userNoteInfo.userNote
        )
    }


}