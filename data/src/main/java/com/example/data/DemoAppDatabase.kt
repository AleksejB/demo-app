package com.example.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.daos.*
import com.example.data.dto.CounterDto
import com.example.data.dto.NoteDto
import com.example.data.dto.UserDto

@Database(entities = [UserDto::class, CounterDto::class, NoteDto::class], version = 3)
abstract class DemoAppDatabase: RoomDatabase() {

    abstract fun getUserDao(): UserLocalDataSource
    abstract fun getCounterDao(): CounterLocalDataSource
    abstract fun getUserCounterDao(): UserCounterLocalDataSource
    abstract fun getNoteDao(): NoteLocalDataSource
    abstract fun getUserNoteDao(): UserNoteLocalDataSource
    abstract fun getUserNoteInfoDao(): UserNoteInfoLocalDataSource
}