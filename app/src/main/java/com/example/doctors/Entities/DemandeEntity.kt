package com.example.doctors.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "demandes")
data class DemandeEntity (

    val obj:String,
    val msg:String,
    val idmed:Int,
    var isSynchronized:Int =0

)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "demande_id")
    var demandeId:Int?=null
}