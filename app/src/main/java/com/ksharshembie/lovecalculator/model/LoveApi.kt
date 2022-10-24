package com.ksharshembie.lovecalculator.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun calculate(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "d53308bc15msh6bd3f47cb83af5bp159c6ejsnabec46e48e55",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}