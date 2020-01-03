package com.tflite.ricevarietiesclassificationvgg16net_nf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar

class Bantuan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bantuan)

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = "Halaman Bantuan"
        }
    }
}
