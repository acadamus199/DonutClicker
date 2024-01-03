package com.example.donutclicker

import android.content.Intent
import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var money = intent.getIntExtra("money",0)
        val imageView: ImageView = findViewById<ImageView>(R.id.GIF)

        findViewById<TextView>(R.id.counter).text = money.toString()
        Thread{
            val source: ImageDecoder.Source = ImageDecoder.createSource(resources, R.drawable.giphy)
            val drawable: Drawable = ImageDecoder.decodeDrawable(source)
            imageView.setImageDrawable(drawable)
            (drawable as? AnimatedImageDrawable)?.start()
        }.start()


        imageView.setOnClickListener{
            if(money == 100) {
                money -= 100
                imageView.isClickable = false
                var bundle = Bundle()
                bundle.putInt("money", money)
                bundle.putBoolean("auto", true)
                startActivity(Intent(this, MainActivity::class.java).putExtras(bundle))
                Toast.makeText(this, "U've been blessed by multiplier", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Bring me 100 money", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<ImageView>(R.id.shop).setOnClickListener {
            finish()
        }


    }
}