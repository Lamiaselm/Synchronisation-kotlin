package com.example.doctors.Retrofit

import com.example.doctors.DataClass.Demande
import com.example.doctors.DataClass.Doctor
import com.example.doctors.Entities.DemandeEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface Endpoint {
    @GET("all")
    fun getDocs(): Call<List<Doctor>>
    @POST("send")
    fun send(
        @Body demande: Demande): Call<String>
    @POST("add")
    fun add(
        @Body demandeEntity: DemandeEntity): Call<String>
}