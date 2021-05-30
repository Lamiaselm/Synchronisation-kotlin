package com.example.doctors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDocs()
    }

    private fun getDocs() {
        val call= RetrofitService.endpoint.getDocs()
        call.enqueue(object:Callback<List<Doctor>>{

            override fun onResponse(call: Call<List<Doctor>>, response: Response<List<Doctor>>) {
                if (response.isSuccessful)
                {   val data = response.body()
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
                Toast.makeText(this@MainActivity,"ERREUR PAS DE DATA POUR TOI DESOLE BABY ",Toast.LENGTH_SHORT).show()

            }

        })
    }



}