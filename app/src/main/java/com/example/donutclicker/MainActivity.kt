package com.example.donutclicker

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.donutclicker.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)

        //Variables
        val bundle = intent.extras
        var counting = intent.getIntExtra("money",0)
        var holder = 11
        var multiplier = 1
        var img = R.drawable.full_donut
        val counter = findViewById<TextView>(R.id.counter)
        val dImage = findViewById<ImageView>(R.id.donut_image)
        val shop = findViewById<ImageView>(R.id.shop)
        val sound = findViewById<ImageView>(R.id.sound)
        var mp = MediaPlayer()
        var bool = true
        var unlockAuto = intent.getBooleanExtra("auto",false)
        if(unlockAuto){
            multiplier = 2
        }else{
            multiplier = 1
        }
        counter.text = counting.toString()

        //Biting Effect on Donut
        var bite = MediaPlayer()
        bite.setDataSource(this,(Uri.parse("android.resource://"+this.packageName+"/"+R.raw.bite_effect)))
        bite.prepare()

        //In game Music
        fun AudioStart(){
            mp.setDataSource(this,(Uri.parse("android.resource://"+this.packageName+"/"+R.raw.cafe_music)))
            mp.prepare()
            mp.isLooping = true
            mp.start()
        }
        fun AudioStop(){
            mp.stop()
            mp.release()
            mp = MediaPlayer()
        }
        sound.setOnClickListener{
            if(bool){
                AudioStart()
                bool = false
                sound.setImageResource(R.drawable.play)
            }else{
                AudioStop()
                bool = true
                sound.setImageResource(R.drawable.mute)
            }
        }

        //Counting clicks
        dImage.setOnClickListener {
            when(holder){
                10 -> img = R.drawable.full_donut
                9 -> {
                    img = R.drawable.bitten_donut
                    bite.start()
                }
                5 -> {
                    img = R.drawable.bitten_donut2
                    bite.start()
                }
                0 -> {
                    img = R.drawable.full_donut
                    holder = 11
                    bite.start()
                }
            }
            dImage.setImageResource(img)
            --holder
            counting += multiplier
            counter.text = counting.toString()
        }

        //Changing window
        shop.setOnClickListener {
            AudioStop()
            val bundle = Bundle()
            if(intent.getBooleanExtra("block",false))
                bundle.putBoolean("visible",false)
            bundle.putInt("money",counting)
            startActivity(Intent(this, SecondActivity::class.java).putExtras(bundle))
        }
    }
}