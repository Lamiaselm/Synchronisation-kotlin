package com.example.doctors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_demande.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DemandeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demande)
        send.setOnClickListener {
            val obj=obj.text.toString()
            val msg=msg.text.toString()
            if(obj.isEmpty()){
                Toast.makeText(this,"verifier que vous avez entrer l'objet", Toast.LENGTH_LONG).show()
            }else{
                if(msg.isEmpty()){
                    Toast.makeText(this,"verifier que vous avez entrer votre demande", Toast.LENGTH_LONG).show()
                }
                else{
                    val demande=Demande(obj,msg,1)
                    val request=RetrofitService.sendEndpoint.send(demande)
                    request.enqueue(object:Callback<String>{
                        override fun onFailure(call: Call<String>, t: Throwable) {
                            Toast.makeText(this@DemandeActivity, "error", Toast.LENGTH_LONG).show()


                        }

                        override fun onResponse(call: Call<String>, response: Response<String>) {
                            if (response.isSuccessful)
                            {
                                Toast.makeText(this@DemandeActivity,"success", Toast.LENGTH_LONG).show()

                            }
                        }

                    })



                }
            }
        }
    }
}