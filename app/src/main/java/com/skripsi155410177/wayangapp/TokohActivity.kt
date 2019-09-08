package com.skripsi155410177.wayangapp

import android.app.ProgressDialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tokoh.*
import com.skripsi155410177.wayangapp.adapter.TokohAdapter
import com.skripsi155410177.wayangapp.model.Tokoh
import com.skripsi155410177.wayangapp.model.TokohResult
import com.skripsi155410177.wayangapp.service.ApiClient
import com.skripsi155410177.wayangapp.service.TokohService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TokohActivity : AppCompatActivity() {

    var tokoh : MutableList<Tokoh> = mutableListOf()
    var adapter = TokohAdapter(tokoh)
    val tokohService : TokohService = ApiClient.create()
    lateinit var  progressDialog: ProgressDialog
    lateinit var context : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tokoh)
        context = this

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.title = "Daftar Tokoh Wayang"
        rvWayang.layoutManager = LinearLayoutManager(applicationContext)
        rvWayang.adapter = adapter

        getAllWayang()
    }

    fun getAllWayang() {
        progressDialog = ProgressDialog(context)
        progressDialog.setMessage("Loading...")
        progressDialog.setCancelable(false)
        progressDialog.show()
        val call : Call<TokohResult> = tokohService.getAllWayang()
        getData(call)
    }

    fun getData(call : Call<TokohResult>) {
        call.enqueue(object : Callback<TokohResult> {
            override fun onFailure(call: Call<TokohResult>?, t: Throwable?) {
                Toast.makeText(applicationContext, "${t.toString()}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<TokohResult>?, response: Response<TokohResult>?) {
                if (response?.body() != null) {
                    tokoh = response.body()!!.wayang.toMutableList()
                    adapter = TokohAdapter(tokoh)
                    rvWayang.adapter = adapter
                    progressDialog.dismiss()
                }
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
  /*  override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)

    } */
}
