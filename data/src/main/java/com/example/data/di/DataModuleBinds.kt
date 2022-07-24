package com.example.data.di

import com.example.data.datasource.CounterDataSourceImpl
import com.example.data.datasource.UserCounterDataSourceImpl
import com.example.data.datasource.UserDataSourceImpl
import com.example.data.dto.UserCounterDto
import com.example.data.dto.UserDto
import com.example.data.mapping.UserCounterMapper
import com.example.data.mapping.UserMapper
import com.example.domain.datasource.CounterDataSource
import com.example.domain.datasource.UserCounterDataSource
import com.example.domain.datasource.UserDataSource
import com.example.domain.mapping.Mapper
import com.example.domain.model.User
import com.example.domain.model.UserCounter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModuleBinds {

    @Binds
    abstract fun bindUserDataSource(userDataSourceImpl: UserDataSourceImpl): UserDataSource

    @Binds
    abstract fun bindCounterDataSource(counterDataSourceImpl: CounterDataSourceImpl): CounterDataSource

    @Binds
    abstract fun bindUserCounterDataSource(userCounterDataSourceImpl: UserCounterDataSourceImpl): UserCounterDataSource

    @Binds
    abstract fun bindUserMapper(userMapper: UserMapper): Mapper<UserDto, User>

    @Binds
    abstract fun bindUserCounterMapper(userCounterMapper: UserCounterMapper): Mapper<UserCounterDto, UserCounter>
}