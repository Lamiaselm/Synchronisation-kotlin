package com.example.doctors.RoomDAO

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.doctors.Entities.DemandeEntity

@Database(entities = arrayOf(DemandeEntity::class),version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun getDeamndeDao():DemandeDao

}