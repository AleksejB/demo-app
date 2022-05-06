package com.example.demoappv1.data

import com.example.demoappv1.User
import com.example.demoappv1.UserDatabase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToOneOrDefault
import com.squareup.sqldelight.runtime.coroutines.mapToOneOrNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
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