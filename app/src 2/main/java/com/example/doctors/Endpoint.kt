package com.example.doctors

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface Endpoint {
    @GET("all")
    fun getDocs(): Call<List<Doctor>>
    @POST("send")
    fun send(
        @Body demande: Demande): Call<String>
}