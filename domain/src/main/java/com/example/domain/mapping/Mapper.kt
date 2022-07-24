package com.example.domain.mapping

interface Mapper<I, O> {
    fun map(input: I): O
}