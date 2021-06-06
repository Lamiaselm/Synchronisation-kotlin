package com.example.doctors.RoomDAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.doctors.Entities.DemandeEntity
@Dao
interface DemandeDao {

     @Insert
     fun addDemande(vararg demandeEntity: DemandeEntity)
     @Update
     fun update(demandeEntity: DemandeEntity)

     @Query("select * from demandes where isSynchronized=0")
     fun getDemandeToSynchronize():List<DemandeEntity>
     @Query("select * from demandes ")
     fun getDemande():List<DemandeEntity>
}