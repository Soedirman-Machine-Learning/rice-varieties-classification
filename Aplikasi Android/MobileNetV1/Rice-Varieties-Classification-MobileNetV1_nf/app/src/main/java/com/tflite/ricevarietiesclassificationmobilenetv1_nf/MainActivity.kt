package com.tflite.ricevarietiesclassificationmobilenetv1_nf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //memperkenalkan button yang sudah ditambahkan di layout activity_main.xml
        val btnPendeteksi: Button = findViewById(R.id.btn_move_detection)
        //menambahkan event onClick pada button btnMoveDetection
        btnPendeteksi.setOnClickListener(this)

        val btnDeskripsi: Button = findViewById(R.id.btn_move_description)
        btnDeskripsi.setOnClickListener(this)

        val btnBantuan: Button = findViewById(R.id.btn_move_help)
        btnBantuan.setOnClickListener(this)

        val btnTentang: Button = findViewById(R.id.btn_move_about)
        btnTentang.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_move_detection -> {
                //menambahkan suatu Intent pada method onClick()
                val moveIntent = Intent(this@MainActivity, Pendeteksi::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_description -> {
                val moveIntent = Intent(this@MainActivity, Deskripsi::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_help -> {
                val moveIntent = Intent(this@MainActivity, Bantuan::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_about -> {
                val moveIntent = Intent(this@MainActivity, Tentang::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
