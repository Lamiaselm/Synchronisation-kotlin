package com.example.doctors

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val endpoint :Endpoint by lazy {
        Retrofit.Builder().baseUrl("https://8302c110c0c7.ngrok.io/"). addConverterFactory(
            GsonConverterFactory.create()). build().create(Endpoint::class.java)
    }
    val sendEndpoint:Endpoint by lazy {
        Retrofit.Builder().baseUrl("https://8302c110c0c7.ngrok.io/").addConverterFactory(
            GsonConverterFactory.create()).build().create(Endpoint::class.java)

    }
}