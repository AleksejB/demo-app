package com.example.demoappv1.di

import android.app.Application
import android.service.autofill.UserData
import com.example.demoappv1.UserDatabase
import com.example.demoappv1.data.UserDataSource
import com.example.demoappv1.data.UserDataSourceImpl
import com.example.demoappv1.repository.CounterRepository
import com.example.demoappv1.repository.CounterRepositoryImpl
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)//not sure why a singleton
object AppModule { //naming of this, need clarification

    @Provides
    @Singleton
    fun provideCounterRepository(userDataSource: UserDataSource): CounterRepository {
        return CounterRepositoryImpl(userDataSource)
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