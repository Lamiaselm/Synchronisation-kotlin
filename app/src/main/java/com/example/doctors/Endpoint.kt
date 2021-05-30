package com.example.doctors

import retrofit2.Call
import retrofit2.http.GET


interface Endpoint {
    @GET("all")
    fun getDocs(): Call<List<Doctor>>
}