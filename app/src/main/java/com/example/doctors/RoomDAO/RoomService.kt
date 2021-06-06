package com.example.doctors.RoomDAO

import android.content.Context
import androidx.room.Room

object RoomService {

    lateinit var context: Context

    val appDataBase: AppDataBase by lazy {
        Room.databaseBuilder(context, AppDataBase::class.java,"conseilsdb").allowMainThreadQueries().build()
    }

}