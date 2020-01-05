package com.tflite.ricevarietiesclassificationmobilenetv1_nf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
//import android.R
import android.os.Handler
import android.view.Window


class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash_screen)

        //tvSplash = findViewById(R.id.tvSplash) as TextView

        //setelah loading maka akan langsung berpindah ke MainActivity
        val handler = Handler()
        handler.postDelayed(Runnable {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }, 3000L) //3000 L = 3 detik

    }
}
