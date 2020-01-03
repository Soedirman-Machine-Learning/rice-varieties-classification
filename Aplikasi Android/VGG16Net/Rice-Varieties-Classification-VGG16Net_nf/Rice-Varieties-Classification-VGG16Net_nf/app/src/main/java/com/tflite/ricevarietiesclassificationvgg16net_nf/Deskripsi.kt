package com.tflite.ricevarietiesclassificationvgg16net_nf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar

class Deskripsi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deskripsi)

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = "Deskripsi Varietas Beras"
        }
    }
}
