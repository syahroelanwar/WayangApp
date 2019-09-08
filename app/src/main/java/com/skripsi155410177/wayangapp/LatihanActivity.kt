package com.skripsi155410177.wayangapp

import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_latihan.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONException
import android.net.ConnectivityManager
import com.skripsi155410177.wayangapp.model.Quiz

class LatihanActivity : AppCompatActivity() {

    lateinit var context : Context
    var QuestionList : MutableList<Quiz> = ArrayList()
    var index = -1
    var score = 0
    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan)
        context = this
        btnNext.isEnabled = false
        btnNext.alpha - 0.5.toFloat()
        try{
            getQuestions().execute()
        }catch(e: Exception){
            Toast.makeText(this,e.message,Toast.LENGTH_SHORT)
            startActivity(Intent(this,MainActivity::class.java))
        }

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        val dialog = AlertDialog.Builder(context)
        dialog.setTitle("Peringatan !")
        dialog.setMessage("Anda yakin selesai ?")
        dialog.setPositiveButton("Ya") { dialog, which ->
            dialog?.dismiss()
            super.onBackPressed()
        }
        dialog.setNegativeButton("Tidak") { dialog, which -> dialog?.dismiss() }
        dialog.show()
    }
    fun UpdateQuestion(){
        val selected = rg_choice.checkedRadioButtonId
        if(selected == -1){
            Toast.makeText(this, "Silahkan Pilih Jawaban Anda.", Toast.LENGTH_SHORT).show()
            return
        }
        if(index<QuestionList.size){
            when(selected){
                rb_choice1.id->{
                    if(QuestionList[index].Answer == 1)
                        score++
                }
                rb_choice2.id->{
                    if(QuestionList[index].Answer == 2)
                        score++
                }
                rb_choice3.id->{
                    if(QuestionList[index].Answer == 3)
                        score++
                }
                rb_choice4.id->{
                    if(QuestionList[index].Answer == 4)
                        score++
                }
            }
            index++
            if(index<QuestionList.size){
                tv_question.text = QuestionList[index].Question
                rb_choice1.text = QuestionList[index].Option1
                rb_choice2.text = QuestionList[index].Option2
                rb_choice3.text = QuestionList[index].Option3
                rb_choice4.text = QuestionList[index].Option4
                rg_choice.clearCheck()
                if((index+1) == QuestionList.size)
                    btnNext.text = "Finish"
            }else{
                val dialog = AlertDialog.Builder(context)
                dialog.setTitle("Jawaban Anda")
                dialog.setMessage("Anda menjawab " + score + " dari " + QuestionList.size + " Pertanyaan yang benar")
                dialog.setPositiveButton("Tutup",DialogInterface.OnClickListener(){ dialogInterface: DialogInterface, i: Int -> dialogInterface.dismiss()
                    finish()
                })
                dialog.show()
            }
        }
    }

    internal inner class getQuestions : AsyncTask<Void, Void, String>(){
        lateinit var  progressDialog: ProgressDialog
        var hasInternet = false

        override fun onPreExecute() {
            super.onPreExecute()
            progressDialog = ProgressDialog(context)
            progressDialog.setMessage("Loading...")
            progressDialog.setCancelable(false)
            progressDialog.show()
        }

        override fun doInBackground(vararg p0: Void?): String {
            if(isNetworkAvailable()){
                hasInternet = true
                val client = OkHttpClient()
                val url ="http://wayangserver.000webhostapp.com/v1/kuis.php"
                val request = Request.Builder().url(url).build()
                val response = client.newCall(request).execute()
                return response.body()?.string().toString()
            }else {
                return ""
            }
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            progressDialog.dismiss()

            if(hasInternet){
                try {
                    val resultArray = JSONArray(result)
                    for (i in 0..(resultArray.length()-1)){
                        val currentObject = resultArray.getJSONObject(i)
                        val obj = Quiz()
                        obj.Question = currentObject.getString("Question")
                        obj.Option1 = currentObject.getString("Option1")
                        obj.Option2 = currentObject.getString("Option2")
                        obj.Option3 = currentObject.getString("Option3")
                        obj.Option4 = currentObject.getString("Option4")
                        obj.Answer = currentObject.getInt("Answer")
                        QuestionList.add(obj)
                    }

                    if(index == -1){
                        index++
                        tv_question.text = QuestionList[index].Question
                        rb_choice1.text = QuestionList[index].Option1
                        rb_choice2.text = QuestionList[index].Option2
                        rb_choice3.text = QuestionList[index].Option3
                        rb_choice4.text = QuestionList[index].Option4
                    }

                    btnNext.isEnabled = true
                    btnNext.alpha = 1.toFloat()

                    btnNext.setOnClickListener({
                        UpdateQuestion()
                    })
                }catch (e: JSONException){

                }
            }
        }
    }
}
