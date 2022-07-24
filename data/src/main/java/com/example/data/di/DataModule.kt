package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.DemoAppDatabase
import com.example.data.daos.CounterDao
import com.example.data.daos.UserCounterDao
import com.example.data.daos.UserDao
import com.example.domain.datasource.CounterDataSource
import com.example.domain.datasource.UserDataSource
import com.example.domain.repository.CounterRepository
import com.example.data.repository.CounterRepositoryImpl
import com.example.data.repository.UserCounterRepositoryImpl
import com.example.domain.repository.UserRepository
import com.example.data.repository.UserRepositoryImpl
import com.example.domain.datasource.UserCounterDataSource
import com.example.domain.repository.UserCounterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideUserCounterDao(demoAppDatabase: DemoAppDatabase): UserCounterDao {
        return demoAppDatabase.getUserCounterDao()
    }

    @Provides
    @Singleton
    fun provideUserDao(demoAppDatabase: DemoAppDatabase): UserDao {
        return demoAppDatabase.getUserDao()
    }

    @Provides
    @Singleton
    fun provideCounterDao(demoAppDatabase: DemoAppDatabase): CounterDao {
        return demoAppDatabase.getCounterDao()
    }

    @Provides
    @Singleton
    fun provideDemoAppDatabase(@ApplicationContext context: Context): DemoAppDatabase {
        return Room.databaseBuilder(
            context,
            DemoAppDatabase::class.java,
            "demoApp.db"
        ).build()
    }
}