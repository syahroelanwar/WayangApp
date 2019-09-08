package com.skripsi155410177.wayangapp

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import com.skripsi155410177.wayangapp.ndActivity.KontakActivity
import com.skripsi155410177.wayangapp.ndActivity.ProfilActivity
import com.skripsi155410177.wayangapp.ndActivity.TentangActivity

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    lateinit var context : Context
    lateinit var uriString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

        drawerLayout = findViewById(R.id.drawer_layout)
        setSupportActionBar(toolbar)
        setUpDrawerLayout()

        btn1.setOnClickListener(){
            startActivity(Intent(this,TokohActivity::class.java))
        }

        btn2.setOnClickListener(){
            startActivity(Intent(this, CeritaActivity::class.java))
        }

        btn3.setOnClickListener(){
            startActivity(Intent(this, MateriActivity::class.java))
        }

        btn4.setOnClickListener(){
            startActivity(Intent(this, LatihanActivity::class.java))
        }

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawerLayout.closeDrawers()

            when(menuItem.itemId){
                R.id.nav1 -> {
                    startActivity(Intent(this, ProfilActivity::class.java))
                    drawerLayout.openDrawer(GravityCompat.START)
                }
                R.id.nav2 -> {
                    startActivity(Intent(this, KontakActivity::class.java))
                    drawerLayout.openDrawer(GravityCompat.START)
                }
                R.id.nav3 -> {
                    startActivity(Intent(this, TentangActivity::class.java))
                    drawerLayout.openDrawer(GravityCompat.START)
                }
                R.id.nav4 -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com"))
                    startActivity(intent)
                    drawerLayout.openDrawer(GravityCompat.START)
                }
                R.id.nav5 -> {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    uriString = "Aplikasi Pembelajaran Tokoh Wayang "+" https://play.google.com"
                    intent.putExtra(Intent.EXTRA_TEXT,uriString)
                    startActivity(Intent.createChooser(intent,"Bagikan Lewat"))
                    drawerLayout.openDrawer(GravityCompat.START)
                }
                R.id.nav6 -> {
                    ext()
                    //Animatoo.animateZoom(this)
                    drawerLayout.openDrawer(GravityCompat.START)
                }
            }
            true
        }

        drawerLayout.addDrawerListener(
            object : DrawerLayout.DrawerListener {
                override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                    // Respond when the drawer's position changes
                }

                override fun onDrawerOpened(drawerView: View) {
                    // Respond when the drawer is opened
                }

                override fun onDrawerClosed(drawerView: View) {
                    // Respond when the drawer is closed
                }

                override fun onDrawerStateChanged(newState: Int) {
                    // Respond when the drawer motion state changes
                }
            }
        )

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setUpDrawerLayout() {
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun ext(){
        val dialog = AlertDialog.Builder(context)
        dialog.setTitle("Peringatan !")
        dialog.setMessage("Anda yakin ingin keluar ?")
        dialog.setPositiveButton("Ya",{ dialogInterface : DialogInterface, i: Int ->
            finish()
            super.onBackPressed()
        })
        dialog.setNegativeButton("Tidak", { dialogInterface : DialogInterface, i: Int -> })
        dialog.show()
    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            ext()
        }
    }
}
