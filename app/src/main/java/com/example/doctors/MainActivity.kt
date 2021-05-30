package com.example.doctors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list_doc.layoutManager = LinearLayoutManager(this)
        list_doc.adapter = MyAdapter(this,loadData())
    }
    fun loadData():List<Doctor> {
        val data = mutableListOf<Doctor>()
        data.add(Doctor("Nekamiche","Noha","05554678","dentiste",R.drawable.pic1,36.72242413411826, 3.168844018174953))
        data.add(Doctor("Selmane","Lamia","05554678","pediate",R.drawable.pic2,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Souha","05554678","dentiste",R.drawable.pic3,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Issam","05554678","dentiste",R.drawable.pic4,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Abdelkader","05554678","dentiste",R.drawable.pic5,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Halim","05554678","dentiste",R.drawable.pic6,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Noha","05554678","dentiste",R.drawable.pic8,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Noha","05554678","dentiste",R.drawable.pic1,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Noha","05554678","dentiste",R.drawable.pic3,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Noha","05554678","dentiste",R.drawable.pic4,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Noha","05554678","dentiste",R.drawable.pic5,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Noha","05554678","dentiste",R.drawable.pic6,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Noha","05554678","dentiste",R.drawable.pic7,36.71132958509183, 3.160282609052669))
        return data
    }

}