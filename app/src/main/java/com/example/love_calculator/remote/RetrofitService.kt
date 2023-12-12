package com.example.love_calculator.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private var retrofit = Retrofit.Builder()
        .baseUrl("https://love-calculator.p.rapidapi.com/") // Remove the double quotes here
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var api = retrofit.create(LoveApi::class.java)

}