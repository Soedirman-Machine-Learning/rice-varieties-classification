package com.tflite.ricevarietiesclassificationmobilenetv1

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.provider.MediaStore
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_import_gallery.*
import java.io.IOException

class DeteksiDariGaleri : AppCompatActivity() {
    private lateinit var mClassifier: KlasifikasiDariGaleri
    private lateinit var mBitmap: Bitmap

    private val mGalleryRequestCode = 2

    private val mInputSize = 224
    private val mModelPath = "Klasifikasi_3_Varietas_Beras_MobileNet.tflite"
    private val mLabelPath = "Klasifikasi_3_Varietas_Beras_MobileNet.txt"
    private val mSamplePath = "basmathi.jpg"

    private var lastProcessingTimeMs: Long = 0

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = "Pendeteksi Varietas Beras"
        }

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_import_gallery)
        mClassifier = KlasifikasiDariGaleri(assets, mModelPath, mLabelPath, mInputSize)

        resources.assets.open(mSamplePath).use {
            mBitmap = BitmapFactory.decodeStream(it)
            mBitmap = Bitmap.createScaledBitmap(mBitmap, mInputSize, mInputSize, true)
            mPhotoImageView.setImageBitmap(mBitmap)
        }

        mGalleryButton.setOnClickListener {
            val callGalleryIntent = Intent(Intent.ACTION_PICK)
            callGalleryIntent.type = "image/*"
            startActivityForResult(callGalleryIntent, mGalleryRequestCode)
        }
        mDetectButton.setOnClickListener {
            val startTime = SystemClock.uptimeMillis()//menghitung waktu awal
            val results = mClassifier.recognizeImage(mBitmap).firstOrNull()
            mResultTextView.text= results?.title+"\n Probabilitas: "+results?.percent+"%"
            lastProcessingTimeMs = SystemClock.uptimeMillis() - startTime//menghitung lamanya proses
            val waktu = lastProcessingTimeMs.toString()//konversi ke string
            delaytime.text = "$waktu ms "

        }
    }

    @SuppressLint("MissingSuperCall", "SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == mGalleryRequestCode) {
            if (data != null) {
                val uri = data.data

                try {
                    mBitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                println("Selesai!")
                mBitmap = scaleImage(mBitmap)
                mPhotoImageView.setImageBitmap(mBitmap)

            }
        } else {
            Toast.makeText(this, "Unrecognized request code", Toast.LENGTH_LONG).show()

        }
    }


    fun scaleImage(bitmap: Bitmap?): Bitmap {
        val orignalWidth = bitmap!!.width
        val originalHeight = bitmap.height
        val scaleWidth = mInputSize.toFloat() / orignalWidth
        val scaleHeight = mInputSize.toFloat() / originalHeight
        val matrix = Matrix()
        matrix.postScale(scaleWidth, scaleHeight)
        return Bitmap.createBitmap(bitmap, 0, 0, orignalWidth, originalHeight, matrix, true)
    }
}