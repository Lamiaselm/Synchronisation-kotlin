package com.example.doctors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.work.*
import com.example.doctors.Entities.DemandeEntity
import com.example.doctors.RoomDAO.RoomService
import com.example.doctors.Service.SyncService
import kotlinx.android.synthetic.main.activity_demande.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DemandeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demande)
        send.setOnClickListener {

            val  demande = DemandeEntity(obj=obj.text.toString(),msg=msg.text.toString(),idmed = 1)
            RoomService.appDataBase.getDeamndeDao().addDemande(demande)
           val get= RoomService.appDataBase.getDeamndeDao().getDemande()

            Toast.makeText(this@DemandeActivity, get.toString(), Toast.LENGTH_LONG).show()

            obj.text.clear()
            msg.text.clear()
            scheduleSycn()
        }
    }
    private fun scheduleSycn() {
        val constraints = Constraints.Builder().
        setRequiredNetworkType(NetworkType.CONNECTED).
            //    setRequiresBatteryNotLow(true).
        build()
        val req= OneTimeWorkRequest.Builder (SyncService::class.java).
        setConstraints(constraints).addTag("id1").
        build()
        val workManager = WorkManager.getInstance(this)
        workManager.enqueueUniqueWork("work", ExistingWorkPolicy.REPLACE,req)

    }
}