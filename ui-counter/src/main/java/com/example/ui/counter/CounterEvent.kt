package com.example.ui.counter

sealed interface CounterEvent {
    object IncrementPressed: CounterEvent
    object DecrementPressed: CounterEvent
    object NumberPressed: CounterEvent
    object WriteNoteClicked: CounterEvent
    object SeeNotesClicked: CounterEvent
}