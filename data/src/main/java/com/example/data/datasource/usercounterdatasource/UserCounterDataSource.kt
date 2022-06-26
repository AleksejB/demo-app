package com.example.data.datasource.usercounterdatasource

import com.example.demoappv1.GetUserAndCount
import kotlinx.coroutines.flow.Flow

interface UserCounterDataSource {
    fun getUserAndCount(userId: String): Flow<List<GetUserAndCount?>>
}