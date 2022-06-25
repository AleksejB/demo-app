package com.example.data.datasource.userdatasource

import com.example.data.datasource.userdatasource.UserDataSource
import com.example.demoappv1.User
import com.example.demoappv1.UserDatabase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToOneOrNull
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class UserDataSourceImpl @Inject constructor(
    db: UserDatabase
): UserDataSource {

    private val queries = db.userQueries

    override fun getUserByUsernameAsFlow(userName: String): Flow<User?> {
        return queries.getUserByUsername(userName).asFlow().mapToOneOrNull()
    }

    override suspend fun getUserByUsername(userName: String): User? {
        return queries.getUserByUsername(userName).executeAsOneOrNull()
    }

    override suspend fun updateUserCountByUsername(newCount: Int, userName: String) {
        return queries.updateUserCountByUsername(newCount, userName)
    }

    override suspend fun insertNewUser(userName: String, count: Int) {
        return queries.insertNewUser(userName, count)
    }
}