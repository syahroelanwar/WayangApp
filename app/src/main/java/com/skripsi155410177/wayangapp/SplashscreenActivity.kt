package com.skripsi155410177.wayangapp

import android.content.Intent
import android.graphics.drawable.TransitionDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import kotlinx.android.synthetic.main.activity_splashscreen.*
import java.lang.Exception
import android.view.animation.AnimationUtils

class SplashscreenActivity : AppCompatActivity() {

    var stAnim: Boolean = false
    lateinit var alphaAnim: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val background = object : Thread(){
            override fun run(){
                try {
                    alpa()
                    if(stAnim==true){
                        splash()
                    }
                    Thread.sleep(3000)
                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }catch(e: Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
    fun alpa(){
        alphaAnim = AnimationUtils.loadAnimation(this, R.anim.alpha)
        alphaAnim.startTime = Animation.START_ON_FIRST_FRAME.toLong()
        img.startAnimation(alphaAnim)
        stAnim = true
    }

    fun splash(){
        img.setImageResource(R.drawable.sp_anim_color)
        val transition = img.drawable as TransitionDrawable
        transition.startTransition(3000)
    }

}
