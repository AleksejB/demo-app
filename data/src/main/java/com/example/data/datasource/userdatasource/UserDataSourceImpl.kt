package com.example.data.datasource.userdatasource

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

//    override suspend fun getUserById(userId: String): User? {
//        return queries.getUserById(userId).executeAsOneOrNull()
//    }

    override suspend fun getUserByFirstAndLastName(firstName: String, lastName: String): User? {
        return queries.getUserByFirstAndLastName(
            userFirstName = firstName,
            userLastName = lastName
        ).executeAsOneOrNull()
    }

    override suspend fun updateUser(userId: String, firstName: String, lastName: String) {
        return queries.updateUser(
            userId = userId,
            userFirstName = firstName,
            userLastName = lastName
        )
    }

    override suspend fun insertNewUser(userId: String, firstName: String, lastName: String) {
        return queries.insertUser(
            userId = userId,
            userFirstName = firstName,
            userLastName = lastName
        )
    }
}