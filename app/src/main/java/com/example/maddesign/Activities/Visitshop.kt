package com.example.maddesign.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.maddesign.R

class Visitshop : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visitshop)

        val Register4Btn = findViewById<ImageButton>(R.id.imageButton4)
        Register4Btn.setOnClickListener {
            val Intent = Intent(this, ItemView::class.java)
            startActivity(Intent)
        }

    }
}