package com.tflite.ricevarietiesclassificationvgg16net

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar

class Tentang : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tentang)

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = "Tentang Aplikasi"
        }
    }
}
