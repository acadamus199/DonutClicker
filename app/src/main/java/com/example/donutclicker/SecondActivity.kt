package com.example.donutclicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //Variables
        var holder = 10
        val counter = findViewById<TextView>(R.id.counter)


        findViewById<ImageView>(R.id.donut_image).setOnClickListener {
            holder--
            counter.text = holder.toString()
            finish()
        }

    }
}