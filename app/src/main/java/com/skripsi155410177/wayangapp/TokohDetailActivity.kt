package com.skripsi155410177.wayangapp

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.app.AlertDialog
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_tokoh_detail.*
import com.skripsi155410177.wayangapp.model.Tokoh
import com.skripsi155410177.wayangapp.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder

class TokohDetailActivity : AppCompatActivity() {

    lateinit var  progressDialog: ProgressDialog
    lateinit var context : Context
    private var collapsingToolbarLayout: CollapsingToolbarLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tokoh_detail)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar) as CollapsingToolbarLayout
        collapsingToolbarLayout!!.title = "Detail Tokoh Wayang"
        collapsingToolbarLayout!!.setExpandedTitleColor(resources.getColor(android.R.color.transparent))

        context = this
        val intent = intent
        val id = intent.extras.get("id")

        val tokohService = ApiClient.create()
        val call : Call<Tokoh> = tokohService.getWayangDetail(id.toString())
        progressDialog = ProgressDialog(context)
        progressDialog.setMessage("Loading...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        call.enqueue(object : Callback<Tokoh> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<Tokoh>?, response: Response<Tokoh>?) {
                val tokoh = response?.body()
                if (tokoh != null) {
                    var imgPath = StringBuilder()
                    imgPath.append(getString(R.string.img_path)).append(tokoh.foto)
                    Glide.with(applicationContext).load(imgPath.toString()).into(img_wy)
                    t_nama.text =   "Nama          : "+tokoh.nama
                    t_nama_l.text = "Nama Lain : "+tokoh.nama_lain
                    t_sjt.text = "Senjata   : "+tokoh.senjata
                    t_ngr.text = "Negara    : "+tokoh.negara
                    t_ayh.text = "Ayah          : "+tokoh.ayah
                    t_ib.text =  "Ibu              : "+tokoh.ibu
                    t_ps.text =  "Pasangan  : "+tokoh.pasangan
                    t_an.text =  "Anak          : "+tokoh.anak
                    t_ket.text = "Keterangan : "+tokoh.keterangan
                    progressDialog.dismiss()
                }
            }

            override fun onFailure(call: Call<Tokoh>?, t: Throwable?) {
            }
        })


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
