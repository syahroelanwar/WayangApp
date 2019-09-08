package com.skripsi155410177.wayangapp

import android.content.DialogInterface
import android.graphics.drawable.AnimationDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_cerita_detail.*

class CeritaDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cerita_detail)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.title = "Detail Cerita Wayang"

        val fimg = img1.background as AnimationDrawable
        fimg.start()

        val cimg = img2.background as AnimationDrawable
        cimg.start()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Peringatan !")
        dialog.setMessage("Anda yakin selesai ?")
        dialog.setPositiveButton("Ya") { dialog, which ->
            dialog?.dismiss()
            super.onBackPressed()
        }
        dialog.setNegativeButton("Tidak") { dialog, which -> dialog?.dismiss() }
        dialog.show()
    }
}
