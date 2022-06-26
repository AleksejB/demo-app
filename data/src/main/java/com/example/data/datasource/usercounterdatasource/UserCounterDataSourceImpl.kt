package com.example.data.datasource.usercounterdatasource

import com.example.demoappv1.GetUserAndCount
import com.example.demoappv1.UserDatabase
import com.example.domain.model.UserCounter
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import com.squareup.sqldelight.runtime.coroutines.mapToOne
import com.squareup.sqldelight.runtime.coroutines.mapToOneOrNull
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserCounterDataSourceImpl @Inject constructor(
    db: UserDatabase
): UserCounterDataSource {
    private val queries = db.queryQueries

    override fun getUserAndCount(userId: String): Flow<List<GetUserAndCount?>> {
        return queries.getUserAndCount().asFlow().mapToList()

//        return UserCounter(
//            firstName = result?.user_first_name ?: "NULL",
//            lastName = result?.user_last_name ?: "NULL",
//            count = result?.count ?: -1
//        )
    }
}