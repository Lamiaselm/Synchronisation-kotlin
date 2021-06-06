package com.example.doctors

import android.app.Application
import com.example.doctors.RoomDAO.RoomService

class App: Application(){
    override fun onCreate() {
        super.onCreate()
        RoomService.context = applicationContext
    }
}