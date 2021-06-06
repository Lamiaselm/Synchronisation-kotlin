package com.example.doctors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctors.DataClass.Doctor
import com.example.doctors.Retrofit.RetrofitService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDocs()
        button.setOnClickListener{
            val intent = Intent(this,DemandeActivity::class.java)
            startActivity(intent)

        }
    }

    private fun getDocs() {
        val call= RetrofitService.endpoint.getDocs()
        call.enqueue(object:Callback<List<Doctor>>{

            override fun onResponse(call: Call<List<Doctor>>, response: Response<List<Doctor>>) {
                if (response.isSuccessful)
                {    Toast.makeText(this@MainActivity,"SUCCESS",Toast.LENGTH_SHORT).show()

                    val data = response.body()
                    if (data!=null)
                    {


                        list_doc.apply {
                            list_doc.layoutManager = LinearLayoutManager(this@MainActivity)
                            list_doc.adapter = MyAdapter(this@MainActivity,data)

                        }




                    }
                }

            }

            override fun onFailure(call: Call<List<Doctor>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"ERREUR",Toast.LENGTH_SHORT).show()

            }

        })
    }



}