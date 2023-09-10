package com.example.love_calculator

import com.example.love_calculator.model.LoveModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun calculateMatching(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "4572b8d009msh458a6fa627b8ec3p158932jsn908cb2d6551a",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ) : retrofit2.Call<LoveModel>
}