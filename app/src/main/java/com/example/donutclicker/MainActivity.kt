package com.example.donutclicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.donutclicker.databinding.ActivityMainBinding
import kotlinx.coroutines.delay

private lateinit var binding: ActivityMainBinding



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)

        //Variables
        var holder = 11
        var img = R.drawable.full_donut
        val counter = findViewById<TextView>(R.id.counter)
        var dImage = findViewById<ImageView>(R.id.donut_image)

        dImage.setOnClickListener {
            when(holder){
                10 -> img = R.drawable.full_donut
                9 -> img = R.drawable.bitten_donut
                5 -> img = R.drawable.bitten_donut2
                0 -> {img = R.drawable.full_donut
                    holder = 11}
            }
            dImage.setImageResource(img)
            counter.text = (--holder).toString()
            /*val nextPage = Intent(this, SecondActivity::class.java)
            startActivity(nextPage)*/
        }
    }
}