package com.skripsi155410177.wayangapp.ndActivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import kotlinx.android.synthetic.main.activity_profil.*
import com.skripsi155410177.wayangapp.R

class ProfilActivity : AppCompatActivity() {

    private var collapsingToolbarLayout: CollapsingToolbarLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar) as CollapsingToolbarLayout
        collapsingToolbarLayout!!.title = "Profil Aplikasi"
        collapsingToolbarLayout!!.setExpandedTitleColor(resources.getColor(android.R.color.transparent))

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
