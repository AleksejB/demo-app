package com.example.data.repository.usercounterrepository

import com.example.demoappv1.GetUserAndCount
import kotlinx.coroutines.flow.Flow

interface UserCounterRepository {
    fun getUserCounter(userId: String): Flow<List<GetUserAndCount?>>
}