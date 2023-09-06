package com.example.love_calculator

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitService {

    var retrofit = Retrofit.Builder()
        .baseUrl("https://love-calculator.p.rapidapi.com/") // Remove the double quotes here
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var api = retrofit.create(LoveApi::class.java)

}