package com.example.ui_counter.counter

sealed interface CounterEvent {
    object IncrementPressed: CounterEvent
    object DecrementPressed: CounterEvent
    object NumberPressed: CounterEvent
}