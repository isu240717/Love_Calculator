package com.example.love_calculator.di

import android.content.Context
import android.content.SharedPreferences
import com.example.love_calculator.data.local.Pref
import com.example.love_calculator.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(Pref.PREF_NAME, Context.MODE_PRIVATE)
    }
    @Provides
    fun providePref(sharedPreferences: SharedPreferences): Pref {
        return Pref(sharedPreferences)
    }
}