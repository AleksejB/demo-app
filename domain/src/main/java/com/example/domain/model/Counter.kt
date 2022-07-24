package com.example.domain.model

//have seperate domain models and data model, which are mapped to data model and vice versa
data class Counter(
    val email: String,
    val count: Int
)