package com.skripsi155410177.wayangapp.ndActivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tentang.*
import com.skripsi155410177.wayangapp.R
import com.skripsi155410177.wayangapp.adapter.TentangAdapter


class TentangActivity : AppCompatActivity() {

    val nama = arrayOf<String>("Nama Aplikasi","Versi Build","Email","Pengembang","Copyright")
    val des = arrayOf<String>(
        "Pembelajaran Tokoh Wayang",
        "Version 1.0",
        "syahrul.am9773@gmail.com",
        "Muhammad Syahrul Anwar",
        "Copyright © 2019 All rights reserved"
    )

    val imageId = arrayOf<Int>(
        R.drawable.ic_home,R.drawable.ic_about,R.drawable.ic_mail,
        R.drawable.ic_pro,R.drawable.ic_info
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tentang)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Tentang Aplikasi"

        val myListAdapter = TentangAdapter(this,nama,des,imageId)
        listView.adapter = myListAdapter

        listView.setOnItemClickListener(){adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            Toast.makeText(this, "Click on $itemAtPos", Toast.LENGTH_LONG).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
