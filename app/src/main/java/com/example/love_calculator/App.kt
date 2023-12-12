package com.example.love_calculator

import android.app.Application
import androidx.room.Room
import com.example.love_calculator.data.room.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "love-file")
            .allowMainThreadQueries().build()
    }
}