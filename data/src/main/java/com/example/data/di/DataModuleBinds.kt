package com.example.data.di

import com.example.data.dto.UserCounterDto
import com.example.data.dto.UserDto
import com.example.data.dto.UserNoteDto
import com.example.data.dto.UserNoteInfoDto
import com.example.data.mapping.UserCounterMapper
import com.example.data.mapping.UserMapper
import com.example.data.mapping.UserNoteInfoMapper
import com.example.data.mapping.UserNoteMapper
import com.example.domain.mapping.Mapper
import com.example.domain.model.User
import com.example.domain.model.UserCounter
import com.example.domain.model.UserNote
import com.example.domain.model.UserNoteInfo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModuleBinds {

//    @Binds
//    abstract fun bindUserDataSource(userDao: UserDao): UserLocalDataSource

//    @Binds
//    abstract fun bindCounterDataSource(counterDataSourceImpl: CounterDataSourceImpl): CounterDataSource
//
//    @Binds
//    abstract fun bindUserCounterDataSource(userCounterDataSourceImpl: UserCounterDataSourceImpl): UserCounterDataSource

    @Binds
    abstract fun bindUserNoteInfoMapper(userNoteInfoMapper: UserNoteInfoMapper): Mapper<UserNoteInfoDto, UserNoteInfo>

    @Binds
    abstract fun bindUserMapper(userMapper: UserMapper): Mapper<UserDto, User>

    @Binds
    abstract fun bindUserCounterMapper(userCounterMapper: UserCounterMapper): Mapper<UserCounterDto, UserCounter>

    @Binds
    abstract fun userNoteMapper(userNoteMapper: UserNoteMapper): Mapper<UserNoteDto, UserNote>
}