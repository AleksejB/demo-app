package com.example.demoappv1.ui.models.counter

sealed interface CounterEvent {
    object IncrementPressed: CounterEvent
    object DecrementPressed: CounterEvent
    object NumberPressed: CounterEvent
}