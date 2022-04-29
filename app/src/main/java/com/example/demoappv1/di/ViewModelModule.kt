package com.example.demoappv1.di

import com.example.demoappv1.repository.CounterRepository
import com.example.demoappv1.repository.CounterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)//not sure why a singleton
object ViewModelModule { //naming of this, need clarification

    @Provides
    fun provideCounterRepository(): CounterRepository {
        return CounterRepositoryImpl()
    }
}