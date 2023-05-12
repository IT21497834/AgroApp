package com.example.maddesign

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Register1Btn = findViewById<ImageButton>(R.id.myShop)
        Register1Btn.setOnClickListener {
            val Intent = Intent(this,FetchingActivity::class.java)
            startActivity(Intent)
        }

        val Register2Btn = findViewById<ImageButton>(R.id.Addfer)
        Register2Btn.setOnClickListener {
            val Intent = Intent(this,AddFertilizer::class.java)
            startActivity(Intent)
        }

        val Register3Btn = findViewById<ImageButton>(R.id.visitshops2)
        Register3Btn.setOnClickListener {
            val Intent = Intent(this,visitshop::class.java)
            startActivity(Intent)
        }

        val Register5Btn = findViewById<ImageButton>(R.id.profilebtn2)
        Register5Btn.setOnClickListener {
            val Intent = Intent(this,Profile::class.java)
            startActivity(Intent)
        }

        val Register6Btn = findViewById<ImageButton>(R.id.imageButton3)
        Register6Btn.setOnClickListener {
            val Intent = Intent(this,myorders::class.java)
            startActivity(Intent)
        }
    }

}