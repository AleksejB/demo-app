package com.example.data.di

import android.app.Application
import com.example.data.datasource.userdatasource.UserDataSource
import com.example.data.datasource.userdatasource.UserDataSourceImpl
import com.example.data.repository.userrepository.UserRepository
import com.example.data.repository.userrepository.UserRepositoryImpl
import com.example.demoappv1.UserDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideCounterRepository(userDataSource: UserDataSource): UserRepository {
        return UserRepositoryImpl(userDataSource)
    }

    @Provides
    @Singleton
    fun provideUserDataSource(sqlDriver: SqlDriver): UserDataSource {
        return UserDataSourceImpl(UserDatabase(sqlDriver))
    }

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return AndroidSqliteDriver(
            schema = UserDatabase.Schema,
            context = app,
            name = "user.db"
        )
    }
}