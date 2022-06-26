package com.example.data.di

import android.app.Application
import com.example.data.datasource.counterdatasource.CounterDataSource
import com.example.data.datasource.counterdatasource.CounterDataSourceImpl
import com.example.data.datasource.usercounterdatasource.UserCounterDataSource
import com.example.data.datasource.usercounterdatasource.UserCounterDataSourceImpl
import com.example.data.datasource.userdatasource.UserDataSource
import com.example.data.datasource.userdatasource.UserDataSourceImpl
import com.example.data.repository.counterrepository.CounterRepository
import com.example.data.repository.counterrepository.CounterRepositoryImpl
import com.example.data.repository.usercounterrepository.UserCounterRepository
import com.example.data.repository.usercounterrepository.UserCounterRepositoryImpl
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
    fun provideUserRepository(userDataSource: UserDataSource): UserRepository {
        return UserRepositoryImpl(userDataSource)
    }

    @Provides
    @Singleton
    fun provideCounterRepository(counterDataSource: CounterDataSource): CounterRepository {
        return CounterRepositoryImpl(counterDataSource)
    }

    @Provides
    @Singleton
    fun provideUserCounterRepository(userCounterDataSource: UserCounterDataSource): UserCounterRepository {
        return UserCounterRepositoryImpl(userCounterDataSource)
    }

    @Provides
    @Singleton
    fun provideUserDataSource(sqlDriver: SqlDriver): UserDataSource {
        return UserDataSourceImpl(UserDatabase(sqlDriver))
    }

    @Provides
    @Singleton
    fun provideCounterDataSource(sqlDriver: SqlDriver): CounterDataSource {
        return CounterDataSourceImpl(UserDatabase(sqlDriver))
    }

    @Provides
    @Singleton
    fun provideUserCounterDataSource(sqlDriver: SqlDriver): UserCounterDataSource {
        return UserCounterDataSourceImpl(UserDatabase(sqlDriver))
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