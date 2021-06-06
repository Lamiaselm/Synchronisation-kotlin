package com.example.doctors.Service

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import androidx.work.impl.utils.futures.SettableFuture
import com.example.doctors.Entities.DemandeEntity
import com.example.doctors.Retrofit.RetrofitService
import com.example.doctors.RoomDAO.RoomService
import com.google.common.util.concurrent.ListenableFuture
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("RestrictedApi")
class SyncService(val ctx: Context, val workParamters: WorkerParameters):
    ListenableWorker(ctx, workParamters){

    lateinit var  future: SettableFuture<Result>



    override fun startWork(): ListenableFuture<Result> {
        println("hello")

        future = SettableFuture.create()
        println("hello")
        val demandes = RoomService.appDataBase.getDeamndeDao().getDemande()
        Toast.makeText(ctx, demandes.toString(), Toast.LENGTH_LONG).show()
        println("size"+demandes.size)
        addDemande(demandes.get(0))
        return future
    }





    fun addDemande(demandeEntity: DemandeEntity) {
        val result = RetrofitService.endpoint.add(demandeEntity)
        result.enqueue(object: Callback<String> {

            override fun onFailure(call: Call<String>?, t: Throwable?) {

                future.set(Result.retry())

            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {

                if(response?.isSuccessful!!) {

                    demandeEntity.isSynchronized = 1

                    RoomService.appDataBase.getDeamndeDao().update(demandeEntity)

                    future.set(Result.success())
                    Log.d("push",response.body().toString())
                    Log.d("push",response.code().toString())

                }
                else
                {
                    future.set(Result.retry())
                    Log.d("push",response.body().toString())
                    Log.d("push",response.code().toString())
                }
            }

        })
    }


}
