package com.example.love_calculator.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.love_calculator.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getDao(): LoveDao
}