package com.example.maddesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class visitshop : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visitshop)

        val Register4Btn = findViewById<ImageButton>(R.id.imageButton4)
        Register4Btn.setOnClickListener {
            val Intent = Intent(this,ItemView::class.java)
            startActivity(Intent)
        }

    }
}