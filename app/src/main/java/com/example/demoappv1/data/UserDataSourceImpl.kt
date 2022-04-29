package com.example.demoappv1.data

import com.example.demoappv1.User
import com.example.demoappv1.UserDatabase
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToOneOrNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    db: UserDatabase
): UserDataSource {

    private val queries = db.userQueries

    override fun getUserByUsername(userName: String): Flow<User?> { //nullable if the user doesn't exist
        return queries.getUserByUsername(userName).asFlow().mapToOneOrNull(Dispatchers.IO)
    }

    override suspend fun updateUserCountByUsername(newCount: Int, userName: String) {
        withContext(Dispatchers.IO) {
            queries.updateUserCountByUsername(newCount, userName)
        }
    }

    override suspend fun insertNewUser(userName: String, count: Int) {
        withContext(Dispatchers.IO) {
            queries.insertNewUser(userName, count)
        }
    }
}