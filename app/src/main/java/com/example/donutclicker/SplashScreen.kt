package com.example.donutclicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var imageV_splash =  findViewById<ImageView>(R.id.ImageView_splash)

        imageV_splash.alpha = 0f
        imageV_splash.animate().setDuration(1000).alpha(1f).withEndAction{
            startActivity(Intent(this,MainActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}