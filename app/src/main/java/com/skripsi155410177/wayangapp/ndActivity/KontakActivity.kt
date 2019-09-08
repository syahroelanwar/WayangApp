package com.skripsi155410177.wayangapp.ndActivity

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_kontak.*
import com.skripsi155410177.wayangapp.R

class KontakActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kontak)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Kontak Aplikasi"

        btnKirim.setOnClickListener {

            val mail = "syahrul.am9773@gmail.com".trim()
            val sbj = subjek.text.toString().trim()
            val psn = pesan.text.toString().trim()


            kirimEmail(mail, sbj, psn)
        }
    }

    private fun kirimEmail(mail: String, sbj: String, psn: String) {

        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"

        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(mail))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, sbj)
        mIntent.putExtra(Intent.EXTRA_TEXT, psn)


        try {
            startActivity(Intent.createChooser(mIntent, "Pilih Email Klien..."))
        }
        catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
