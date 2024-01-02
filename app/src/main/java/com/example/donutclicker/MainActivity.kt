package com.example.donutclicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.donutclicker.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)

        //Variables
        var holder = 10
        val counter = findViewById<TextView>(R.id.counter)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener{
            val nextPage = Intent(this, SecondActivity::class.java)
            startActivity(nextPage)
        }

        findViewById<ImageView>(R.id.donut_image).setOnClickListener {
            holder--
            counter.text = holder.toString()
            val nextPage = Intent(this, SecondActivity::class.java)
            startActivity(nextPage)
        }
    }
}