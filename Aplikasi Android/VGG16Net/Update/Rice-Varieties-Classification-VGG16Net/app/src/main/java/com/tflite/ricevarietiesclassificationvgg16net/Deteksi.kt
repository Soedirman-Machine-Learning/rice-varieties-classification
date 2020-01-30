package com.tflite.ricevarietiesclassificationvgg16net

data class Deteksi(
    val name: String,
    val probability: Float
) {
    override fun toString() =
        "$name : ${probability*100}%"
}