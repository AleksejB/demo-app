package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.DemoAppDatabase
import com.example.data.daos.*
import com.example.data.dto.UserCounterDto
import com.example.data.dto.UserDto
import com.example.data.dto.UserNoteDto
import com.example.data.dto.UserNoteInfoDto
import com.example.data.mapping.UserNoteInfoMapper
import com.example.data.repository.*
import com.example.data.repository.UserRepositoryImpl
import com.example.domain.mapping.Mapper
import com.example.domain.model.User
import com.example.domain.model.UserCounter
import com.example.domain.model.UserNote
import com.example.domain.model.UserNoteInfo
import com.example.domain.repository.*
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
    fun provideUserNoteInfoRepository(
        userNoteInfoLocalDataSource: UserNoteInfoLocalDataSource,
        userNoteInfoMapper: Mapper<UserNoteInfoDto, UserNoteInfo>
    ): UserNoteInfoRepository {
        return UserNoteInfoRepositoryImpl(
            userNoteInfoLocalDataSource,
            userNoteInfoMapper
        )
    }

    @Provides
    @Singleton
    fun provideUserNoteRepository(
        userNoteLocalDataSource: UserNoteLocalDataSource,
        userNoteMapper: Mapper<UserNoteDto, UserNote>
    ): UserNoteRepository {
        return UserNoteRepositoryImpl(userNoteLocalDataSource, userNoteMapper)
    }

    @Provides
    @Singleton
    fun provideNoteRepository(noteLocalDataSource: NoteLocalDataSource): NoteRepository {
        return NoteRepositoryImpl(noteLocalDataSource)
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        userLocalDataSource: UserLocalDataSource,
        userMapper: Mapper<UserDto, User>
    ): UserRepository {
        return UserRepositoryImpl(userLocalDataSource, userMapper)
    }

    @Provides
    @Singleton
    fun provideCounterRepository(counterLocalDataSource: CounterLocalDataSource): CounterRepository {
        return CounterRepositoryImpl(counterLocalDataSource)
    }

    @Provides
    @Singleton
    fun provideUserCounterRepository(
        userCounterLocalDataSource: UserCounterLocalDataSource,
        userCounterMapper: Mapper<UserCounterDto, UserCounter>
    ): UserCounterRepository {
        return UserCounterRepositoryImpl(userCounterLocalDataSource, userCounterMapper)
    }

    @Provides
    @Singleton
    fun provideUserNoteInfoDao(demoAppDatabase: DemoAppDatabase): UserNoteInfoLocalDataSource {
        return demoAppDatabase.getUserNoteInfoDao()
    }

    @Provides
    @Singleton
    fun provideUserNoteDao(demoAppDatabase: DemoAppDatabase): UserNoteLocalDataSource {
        return demoAppDatabase.getUserNoteDao()
    }

    @Provides
    @Singleton
    fun provideNoteDao(demoAppDatabase: DemoAppDatabase): NoteLocalDataSource {
        return demoAppDatabase.getNoteDao()
    }

    @Provides
    @Singleton
    fun provideUserCounterDao(demoAppDatabase: DemoAppDatabase): UserCounterLocalDataSource {
        return demoAppDatabase.getUserCounterDao()
    }

    @Provides
    @Singleton
    fun provideUserDao(demoAppDatabase: DemoAppDatabase): UserLocalDataSource {
        return demoAppDatabase.getUserDao()
    }

    @Provides
    @Singleton
    fun provideCounterDao(demoAppDatabase: DemoAppDatabase): CounterLocalDataSource {
        return demoAppDatabase.getCounterDao()
    }

    @Provides
    @Singleton
    fun provideDemoAppDatabase(@ApplicationContext context: Context): DemoAppDatabase {
        return Room.databaseBuilder(
            context,
            DemoAppDatabase::class.java,
            "demoApp.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}