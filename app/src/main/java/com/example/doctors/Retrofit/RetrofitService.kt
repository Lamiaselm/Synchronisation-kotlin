package com.example.doctors.Retrofit

import com.example.doctors.baseUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val endpoint : Endpoint by lazy {
        Retrofit.Builder().baseUrl(baseUrl). addConverterFactory(
            GsonConverterFactory.create()). build().create(Endpoint::class.java)
    }
    val sendEndpoint: Endpoint by lazy {
        Retrofit.Builder().baseUrl("https://d6c5ffe90571.ngrok.io/").addConverterFactory(
            GsonConverterFactory.create()).build().create(Endpoint::class.java)

    }
}