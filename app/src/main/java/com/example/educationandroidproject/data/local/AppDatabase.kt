package com.example.educationandroidproject.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AppDetailsEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDetailsDao(): AppDetailsDao
}