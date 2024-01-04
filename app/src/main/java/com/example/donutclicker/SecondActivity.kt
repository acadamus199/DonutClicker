package com.example.donutclicker

import android.content.Intent
import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var money = intent.getIntExtra("money",0)
        val clickable = intent.getBooleanExtra("visible", true)
        val imageView: ImageView = findViewById(R.id.GIF)
        val outOfOrder = findViewById<ImageView>(R.id.Out_ofOrder)

        findViewById<TextView>(R.id.counter).text = money.toString()
        Thread{
            val source: ImageDecoder.Source = ImageDecoder.createSource(resources, R.drawable.giphy)
            val drawable: Drawable = ImageDecoder.decodeDrawable(source)
            imageView.setImageDrawable(drawable)
            (drawable as? AnimatedImageDrawable)?.start()
        }.start()

        imageView.isVisible = clickable
        outOfOrder.isVisible = intent.getBooleanExtra("outOfOrder",false)

        imageView.setOnClickListener{
            if(money >= 100) {
                money -= 100
                val bundle = Bundle()
                bundle.putInt("money", money)
                bundle.putBoolean("auto", true)
                bundle.putBoolean("block",true)
                startActivity(Intent(this, MainActivity::class.java).putExtras(bundle))
                Toast.makeText(this, "U've been blessed with 2x multiplier", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Bring me 100 money", Toast.LENGTH_SHORT).show()
            }
            var musicID = R.raw.cat_meow1
            when((1..2).random()){
                1 -> musicID = R.raw.cat_meow1
                2 -> musicID = R.raw.cat_meow2
            }
            val mp = MediaPlayer()
            mp.setDataSource(this,(Uri.parse("android.resource://"+this.packageName+"/"+musicID)))
            mp.prepare()
            mp.start()
        }

        findViewById<ImageView>(R.id.shop).setOnClickListener {
            finish()
        }


    }
}